/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.InstanceNotFoundException;
import metier.entitys.AttributionSecteurDetecteurIntrusion;
import metier.entitys.DetecteurIntrusion;
import metier.entitys.Secteur;
import physique.data.AttributionSecteurDetectionIntrusionServiceORM;
import physique.data.PhysiqueDataFactory;

/**
 *
 * @author damien
 */
public class AttributionSecteurDetecteurIntrusionServiceImpl implements AttributionSecteurDetecteurIntrusionService {

    private AttributionSecteurDetectionIntrusionServiceORM attributionSecteurDetecteurIntrusionSrv = PhysiqueDataFactory.getAttributionSecteurDetectionIntrusionServiceORM();

    @Override
    public void add(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion) throws Exception {
        if (attributionSecteurDetecteurIntrusion != null) {
            if (attributionSecteurDetecteurIntrusion instanceof AttributionSecteurDetecteurIntrusion) {
                attributionSecteurDetecteurIntrusionSrv.add(attributionSecteurDetecteurIntrusion);
            } else {
                throw new InstanceNotFoundException("L'instance ne corespond pas a l'objet passé en argument");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void update(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion) throws Exception {
        if (attributionSecteurDetecteurIntrusion != null) {
            if (attributionSecteurDetecteurIntrusion instanceof AttributionSecteurDetecteurIntrusion) {
                attributionSecteurDetecteurIntrusionSrv.update(attributionSecteurDetecteurIntrusion);
            } else {
                throw new InstanceNotFoundException("L'instance ne corespond pas a l'objet passé en argument");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public void remove(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion) throws Exception {
        if (attributionSecteurDetecteurIntrusion != null) {
            if (attributionSecteurDetecteurIntrusion instanceof AttributionSecteurDetecteurIntrusion) {
                attributionSecteurDetecteurIntrusionSrv.remove(attributionSecteurDetecteurIntrusion);
            } else {
                throw new InstanceNotFoundException("L'instance ne corespond pas a l'objet passé en argument");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
    }

    @Override
    public List<AttributionSecteurDetecteurIntrusion> getAll() throws Exception {
        return this.attributionSecteurDetecteurIntrusionSrv.getAll();
    }

    @Override
    public AttributionSecteurDetecteurIntrusion getBySecteur(Secteur secteur) {
        AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusions = null;
        if (secteur != null) {
            if (secteur instanceof Secteur) {
                attributionSecteurDetecteurIntrusions = this.attributionSecteurDetecteurIntrusionSrv.getBySecteur(secteur);
            } else {
                System.out.println("L'instance de l'objet ne coresspond pas veuiller utiliser la bonne classe de service.");
            }
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return attributionSecteurDetecteurIntrusions;
    }

    @Override
    public void attribuerDetecteurIntrusion(Secteur secteur, DetecteurIntrusion detecteurIntrusion) {
          List<AttributionSecteurDetecteurIntrusion> attributionSecteurDetecteurIntrusions = null;
        try {
            attributionSecteurDetecteurIntrusions = this.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurCameraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean start = true;
        boolean secteurTrouve = false;
        int i = 0;
        while (start) {
            if (!attributionSecteurDetecteurIntrusions.isEmpty()) {
                if (i < attributionSecteurDetecteurIntrusions.size()) {
                    if (attributionSecteurDetecteurIntrusions.get(i).getSecteur().getId().equals(secteur.getId())) {
                        AttributionSecteurDetecteurIntrusion asdi = attributionSecteurDetecteurIntrusions.get(i);
                        asdi.getDetecteurIntrusions().add(detecteurIntrusion);
                        try {
                            this.update(asdi);
                        } catch (Exception ex) {
                            Logger.getLogger(AttributionSecteurCameraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
            AttributionSecteurDetecteurIntrusion asdi = new AttributionSecteurDetecteurIntrusion();
            List<DetecteurIntrusion> detecteurIntrusions = new ArrayList<DetecteurIntrusion>();
            detecteurIntrusions.add(detecteurIntrusion);
            asdi.setDetecteurIntrusions(detecteurIntrusions);
            asdi.setSecteur(secteur);
            try {
                this.add(asdi);
            } catch (Exception ex) {
                Logger.getLogger(AttributionSecteurCameraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void desattribuerDetecteurIntrusion(Secteur secteur, DetecteurIntrusion detecteurIntrusion) {
        List<AttributionSecteurDetecteurIntrusion> attributionSecteurDetecteurIntrusions=null;
        try {
            attributionSecteurDetecteurIntrusions = this.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurCameraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean start = true;
        int i = 0;
        while (start) {
            if (attributionSecteurDetecteurIntrusions.get(i).getSecteur().getId().equals(secteur.getId())) {
                AttributionSecteurDetecteurIntrusion asdi = attributionSecteurDetecteurIntrusions.get(i);
                for (int j = 0; j < asdi.getDetecteurIntrusions().size(); j++) {
                    if (asdi.getDetecteurIntrusions().get(j).getId().equals(detecteurIntrusion.getId())) {
                        asdi.getDetecteurIntrusions().remove(j);
                        start = false;
                    }
                }
                try {
                    this.update(asdi);
                } catch (Exception ex) {
                    Logger.getLogger(AttributionSecteurCameraServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            i++;
        }
    }

    @Override
    public Long count() {
        return this.attributionSecteurDetecteurIntrusionSrv.count();
    }

    @Override
    public AttributionSecteurDetecteurIntrusion getById(Long id) {
        AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion = null;
        if (id != null) {
            attributionSecteurDetecteurIntrusion = this.attributionSecteurDetecteurIntrusionSrv.getById(id);
        } else {
            throw new NullPointerException("Objet passé en parametre égale à null");
        }
        return attributionSecteurDetecteurIntrusion;
    }
    
}
