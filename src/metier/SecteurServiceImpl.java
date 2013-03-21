package metier;

import java.util.List;
import metier.entitys.AttributionSecteurBorneAcces;
import metier.entitys.AttributionSecteurBorneAcces_;
import metier.entitys.AttributionSecteurCamera;
import metier.entitys.AttributionSecteurDetecteurIntrusion;
import metier.entitys.AuthorisationAcces;
import metier.entitys.Secteur;
import physique.data.PhysiqueDataFactory;
import physique.data.SecteurServiceORM;

/**
 * @author damien
 * @author
 * @author
 */

public class SecteurServiceImpl implements SecteurService {    
    
    private SecteurServiceORM secteurSrv = PhysiqueDataFactory.getSecteurServiceORM();
    
    @Override
    public void add(Secteur secteur) throws Exception {
        if(secteur!=null){
            if(secteur instanceof Secteur){
                secteurSrv.add(secteur);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(Secteur secteur) throws Exception {
        if(secteur!=null){
            if(secteur instanceof Secteur){
                secteurSrv.update(secteur);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(Secteur secteur) throws Exception {
        AttributionSecteurBorneAccesService attributionSecteurBorneAccesSrv = MetierFactory.getAttributionSecteurBorneAccesService();
        AttributionSecteurCameraService attributionSecteurCameraSrv = MetierFactory.getAttributionSecteurCameraService();
        AttributionSecteurDetecteurIntrusionService attributionSecteurDetecteurIntrusionSrv = MetierFactory.getAttributionSecteurDetecteurIntrusionService();
        AuthorisationAccesService authorisationAccesSrv = MetierFactory.getAuthorisationAccesService();
        if(secteur!=null){
            if(secteur instanceof Secteur){
                AttributionSecteurBorneAcces acces = attributionSecteurBorneAccesSrv.getBySecteur(secteur);
                if(acces!=null){
                    attributionSecteurBorneAccesSrv.remove(acces);
                }
                AttributionSecteurCamera cameraSrv = attributionSecteurCameraSrv.getBySecteur(secteur);
                if(cameraSrv!=null){
                    attributionSecteurCameraSrv.remove(cameraSrv);
                }
                AttributionSecteurDetecteurIntrusion detecteurIntrusion = attributionSecteurDetecteurIntrusionSrv.getBySecteur(secteur);
                if(detecteurIntrusion!=null){
                    attributionSecteurDetecteurIntrusionSrv.remove(detecteurIntrusion);
                }
                this.secteurSrv.remove(secteur);
            }else{
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        }else{
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<Secteur> getAll() throws Exception {
        return this.secteurSrv.getAll();
    }

    @Override
    public Long count() {
        return this.secteurSrv.count();
    }

    @Override
    public Secteur getById(Long id) {
        Secteur secteur = null;
        if (id != null) {
            secteur = this.secteurSrv.getById(id);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return secteur;
    }
}
