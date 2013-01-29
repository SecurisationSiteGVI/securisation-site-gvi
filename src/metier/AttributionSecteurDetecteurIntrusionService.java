/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.AttributionSecteurDetecteurIntrusion;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public interface AttributionSecteurDetecteurIntrusionService {
    public void add(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion) throws Exception;
    public void update(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion) throws Exception;
    public void remove(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion) throws Exception;
    public List<AttributionSecteurDetecteurIntrusion> getAll() throws Exception;
    public AttributionSecteurDetecteurIntrusion getBySecteur(Secteur secteur);
}
