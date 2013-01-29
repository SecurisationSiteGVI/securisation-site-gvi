/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import metier.entitys.AttributionSecteurBorneAcces;
import metier.entitys.Secteur;

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

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionSecteurBorneAccesCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public AttributionSecteurBorneAcces getBySecteur(Secteur secteur) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionSecteurBorneAccesGetBySecteur");
        query.setParameter("id", secteur.getId());
        AttributionSecteurBorneAcces attributionSecteurBorneAcceses = null;
        try{
             attributionSecteurBorneAcceses = (AttributionSecteurBorneAcces) query.getSingleResult();
        }catch(NoResultException e){
            System.out.println("Pas de résultat dans la base");
        }
       
        Connexion.disconect();
        return attributionSecteurBorneAcceses;
    }
    
}
