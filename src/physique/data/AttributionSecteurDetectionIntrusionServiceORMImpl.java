/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.AttributionSecteurDetecteurIntrusion;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public class AttributionSecteurDetectionIntrusionServiceORMImpl implements AttributionSecteurDetectionIntrusionServiceORM{

    @Override
    public void add(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion) {
        Connexion.getPersistance();
        Connexion.em.persist(attributionSecteurDetecteurIntrusion);
        Connexion.disconect();
    }

    @Override
    public void remove(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(attributionSecteurDetecteurIntrusion));
        Connexion.disconect();
    }

    @Override
    public void update(AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion) {
        Connexion.getPersistance();
        Connexion.em.merge(attributionSecteurDetecteurIntrusion);
        Connexion.disconect();
    }

    @Override
    public List<AttributionSecteurDetecteurIntrusion> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionSecteurDetecteurIntrusionGetAll");
        List<AttributionSecteurDetecteurIntrusion> attributionSecteurDetecteurIntrusions = query.getResultList();
        Connexion.disconect();
        return attributionSecteurDetecteurIntrusions;
    }

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionSecteurDetecteurIntrusionCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public List<AttributionSecteurDetecteurIntrusion> getBySecteur(Secteur secteur) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionSecteurDetecteurIntrusionGetBySecteur");
        query.setParameter("id", secteur.getId());
        List<AttributionSecteurDetecteurIntrusion> attributionSecteurDetecteurIntrusions = query.getResultList();
        Connexion.disconect();
        return attributionSecteurDetecteurIntrusions;
    }
    
}
