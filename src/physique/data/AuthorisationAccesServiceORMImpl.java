/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.AuthorisationAcces;

/**
 *
 * @author damien
 */
public class AuthorisationAccesServiceORMImpl implements AuthorisationAccesServiceORM{

    @Override
    public void add(AuthorisationAcces authorisationAcces) {
        Connexion.getPersistance();
        Connexion.em.persist(authorisationAcces);
        Connexion.disconect();
    }

    @Override
    public void remove(AuthorisationAcces authorisationAcces) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(authorisationAcces));
        Connexion.disconect();
    }

    @Override
    public void update(AuthorisationAcces authorisationAcces) {
        Connexion.getPersistance();
        Connexion.em.merge(authorisationAcces);
        Connexion.disconect();
    }

    @Override
    public List<AuthorisationAcces> getAll() { 
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AuthorisationAccesGetAll");
        List<AuthorisationAcces> authorisationAcceses = query.getResultList();
        Connexion.disconect();
        return authorisationAcceses;
    }

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AuthorisationAccesCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }
    
}
