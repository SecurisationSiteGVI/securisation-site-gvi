/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.List;
import metier.entitys.AttributionSecteurBorneAcces;
import metier.entitys.BorneAcces;
import metier.entitys.Secteur;
import physique.data.AttributionSecteurBorneAccesServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 *
 * @author damien
 */
public class AttributionSecteurBorneAccesServiceImpl implements AttributionSecteurBorneAccesService {

    private AttributionSecteurBorneAccesServiceORM attributionSecteurBorneAccesSrv = PhysiqueDataFactory.getAttributionSecteurBorneAccesServiceORM();

    @Override
    public void add(AttributionSecteurBorneAcces attributionSecteurBorneAcces) {
        if (attributionSecteurBorneAcces != null) {
            if (attributionSecteurBorneAcces instanceof AttributionSecteurBorneAcces) {
                attributionSecteurBorneAccesSrv.add(attributionSecteurBorneAcces);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(AttributionSecteurBorneAcces attributionSecteurBorneAcces) {
        if (attributionSecteurBorneAcces != null) {
            if (attributionSecteurBorneAcces instanceof AttributionSecteurBorneAcces) {
                attributionSecteurBorneAccesSrv.update(attributionSecteurBorneAcces);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(AttributionSecteurBorneAcces attributionSecteurBorneAcces) {
        if (attributionSecteurBorneAcces != null) {
            if (attributionSecteurBorneAcces instanceof AttributionSecteurBorneAcces) {
                attributionSecteurBorneAccesSrv.remove(attributionSecteurBorneAcces);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<AttributionSecteurBorneAcces> getAll() {
        return this.attributionSecteurBorneAccesSrv.getAll();
    }

    @Override
    public AttributionSecteurBorneAcces getBySecteur(Secteur secteur) {
        AttributionSecteurBorneAcces attributionSecteurBorneAcceses = null;
        if (secteur != null) {
            if (secteur instanceof Secteur) {
                attributionSecteurBorneAcceses = this.attributionSecteurBorneAccesSrv.getBySecteur(secteur);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return attributionSecteurBorneAcceses;
    }

    @Override
    public void attribuerBorneAcces(Secteur secteur, BorneAcces borneAcces) {
        List<AttributionSecteurBorneAcces> attributionSecteurBorneAcceses = this.getAll();
        boolean start = true;
        boolean secteurTrouve = false;
        int i = 0;
        while (start) {
            if (!attributionSecteurBorneAcceses.isEmpty()) {
                if (i < attributionSecteurBorneAcceses.size()) {
                    if (attributionSecteurBorneAcceses.get(i).getSecteur().getId().equals(secteur.getId())) {
                        AttributionSecteurBorneAcces acces = attributionSecteurBorneAcceses.get(i);
                        acces.getBorneAccess().add(borneAcces);
                        this.update(acces);
                        secteurTrouve = true;
                        start = false;
                    }
                }else{
                    start=false;
                }
            } else {
                start = false;
            }

            i++;
        }
        if (secteurTrouve == false) {
            AttributionSecteurBorneAcces acces = new AttributionSecteurBorneAcces();
            List<BorneAcces> borneAcceses = new ArrayList<BorneAcces>();
            borneAcceses.add(borneAcces);
            acces.setBorneAccess(borneAcceses);
            acces.setSecteur(secteur);
            this.add(acces);
        }
    }

    @Override
    public void desattribuerBorneAcces(Secteur secteur, BorneAcces borneAcces) {
        List<AttributionSecteurBorneAcces> attributionSecteurBorneAcceses = this.getAll();
        boolean start = true;

        int i = 0;
        while (start) {
            if (attributionSecteurBorneAcceses.get(i).getSecteur().getId().equals(secteur.getId())) {
                AttributionSecteurBorneAcces acces = attributionSecteurBorneAcceses.get(i);
                for (int j = 0; j < acces.getBorneAccess().size(); j++) {
                    if (acces.getBorneAccess().get(j).getId().equals(borneAcces.getId())) {
                        acces.getBorneAccess().remove(j);
                        start = false;
                    }
                }
                this.update(acces);
            }
            i++;
        }

    }
}
