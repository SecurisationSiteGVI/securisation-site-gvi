/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import javax.management.InstanceNotFoundException;
import metier.entitys.AttributionSecteurDetecteurIntrusion;
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
}
