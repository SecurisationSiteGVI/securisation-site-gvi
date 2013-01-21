/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.AttributionSecteurCamera;

/**
 *
 * @author damien
 */
public class AttributionSecteurCameraServiceORMImpl implements AttributionSecteurCameraServiceORM{

    @Override
    public void add(AttributionSecteurCamera attributionSecteurCamera) {
        Connexion.getPersistance();
        Connexion.em.persist(attributionSecteurCamera);
        Connexion.disconect();
    }

    @Override
    public void remove(AttributionSecteurCamera attributionSecteurCamera) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(attributionSecteurCamera));
        Connexion.disconect();
    }

    @Override
    public void update(AttributionSecteurCamera attributionSecteurCamera) {
        Connexion.getPersistance();
        Connexion.em.merge(attributionSecteurCamera);
        Connexion.disconect();
    }

    @Override
    public List<AttributionSecteurCamera> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionSecteurCameraGetAll");
        List<AttributionSecteurCamera> attributionSecteurCameras = query.getResultList();
        Connexion.disconect();
        return attributionSecteurCameras;
    }

    @Override
    public Long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
