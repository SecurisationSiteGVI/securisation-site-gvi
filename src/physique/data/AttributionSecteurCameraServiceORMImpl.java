/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import metier.entitys.AttributionSecteurCamera;
import metier.entitys.AttributionSecteurDetecteurIntrusion;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public class AttributionSecteurCameraServiceORMImpl implements AttributionSecteurCameraServiceORM {

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
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionSecteurCameraCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public AttributionSecteurCamera getBySecteur(Secteur secteur) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionSecteurCameraGetBySecteur");
        query.setParameter("id", secteur.getId());
        AttributionSecteurCamera attributionSecteurCameras = null;
        try {
            attributionSecteurCameras = (AttributionSecteurCamera) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Pas de résultat dans la base");
        }
        Connexion.disconect();
        return attributionSecteurCameras;
    }
}
