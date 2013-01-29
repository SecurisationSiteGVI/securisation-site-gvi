/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.AttributionSecteurDetecteurIntrusion;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public interface AttributionSecteurDetectionIntrusionServiceORM {

    public void add(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion);

    public void remove(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion);

    public void update(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion);

    public Long count();

    public List<AttributionSecteurDetecteurIntrusion> getAll();
     public AttributionSecteurDetecteurIntrusion getBySecteur(Secteur secteur);
}
