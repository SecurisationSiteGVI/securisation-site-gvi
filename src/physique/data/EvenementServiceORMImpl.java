/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.Evenement;

/**
 *
 * @author damien
 */
public class EvenementServiceORMImpl implements EvenementServiceORM{

    @Override
    public void add(Evenement evenement) {
        Connexion.getPersistance();
        Connexion.em.persist(evenement);
        Connexion.disconect();
    }

    @Override
    public void remove(Evenement evenement) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(evenement));
        Connexion.disconect();
    }

    @Override
    public void update(Evenement evenement) {
        Connexion.getPersistance();
        Connexion.em.merge(evenement);
        Connexion.disconect();
    }

    @Override
    public List<Evenement> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("EvenementGetAll");
        List<Evenement> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }
    
}
