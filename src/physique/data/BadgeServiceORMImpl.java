/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.Badge;

/**
 *
 * @author damien
 */
public class BadgeServiceORMImpl implements BadgeServiceORM{

    @Override
    public void add(Badge badge) {
        Connexion.getPersistance();
        Connexion.em.persist(badge);
        Connexion.disconect();
    }

    @Override
    public void remove(Badge badge) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(badge));
        Connexion.disconect();
    }

    @Override
    public void update(Badge badge) {
        Connexion.getPersistance();
        Connexion.em.merge(badge);
        Connexion.disconect();
    }

    @Override
    public List<Badge> getAll() {
       Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("BadgeGetAll");
        List<Badge> badges = query.getResultList();
        Connexion.disconect();
        return badges;
    }

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("badgeCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public List<Badge> getAll(int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("BadgeGetAll");
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Badge> badges = query.getResultList();
        Connexion.disconect();
        return badges;
    }  
}
