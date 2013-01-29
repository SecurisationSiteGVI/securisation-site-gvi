/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.AttributionSecteurCamera;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public interface AttributionSecteurCameraServiceORM {

    public void add(AttributionSecteurCamera attributionSecteurCamera);

    public void remove(AttributionSecteurCamera attributionSecteurCamera);

    public void update(AttributionSecteurCamera attributionSecteurCamera);

    public Long count();

    public List<AttributionSecteurCamera> getAll();
    
    public List<AttributionSecteurCamera> getBySecteur(Secteur secteur);
}
