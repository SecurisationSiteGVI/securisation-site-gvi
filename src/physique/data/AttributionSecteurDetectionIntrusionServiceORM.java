/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.AttributionSecteurDetecteurIntrusion;

/**
 *
 * @author damien
 */
public interface AttributionSecteurDetectionIntrusionServiceORM {
    public void add(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion);

    public void remove(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion);

    public void update(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion);

    public List<AttributionSecteurDetecteurIntrusion> getAll();
}
