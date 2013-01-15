/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.AttributionSecteurBorneAcces;

/**
 *
 * @author damien
 */
public class AttributionSecteurBorneAccesServiceORMImpl implements AttributionSecteurBorneAccesServiceORM{

    @Override
    public void add(AttributionSecteurBorneAcces attributionSecteurBorneAcces) {
       Connexion.getPersistance();
        Connexion.em.persist(attributionSecteurBorneAcces);
        Connexion.disconect();
    }

    @Override
    public void remove(AttributionSecteurBorneAcces attributionSecteurBorneAcces) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(attributionSecteurBorneAcces));
        Connexion.disconect();
    }

    @Override
    public void update(AttributionSecteurBorneAcces attributionSecteurBorneAcces) {
       Connexion.getPersistance();
        Connexion.em.merge(attributionSecteurBorneAcces);
        Connexion.disconect();
    }

    @Override
    public List<AttributionSecteurBorneAcces> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionSecteurBorneAccesGetAll");
        List<AttributionSecteurBorneAcces> attributionSecteurBorneAcceses = query.getResultList();
        Connexion.disconect();
        return attributionSecteurBorneAcceses;
    }
    
}
