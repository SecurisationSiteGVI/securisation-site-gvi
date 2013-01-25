/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.AttributionUtilisateurBadge;
import metier.entitys.Badge;

/**
 *
 * @author damien
 */
public class AttributionUtilisateurBadgeServiceORMImpl implements AttributionUtilisateurBadgeServiceORM{

    @Override
    public void add(AttributionUtilisateurBadge attributionUtilisateurBadge) {
        Connexion.getPersistance();
        Connexion.em.persist(attributionUtilisateurBadge);
        Connexion.disconect();
    }

    @Override
    public void remove(AttributionUtilisateurBadge attributionUtilisateurBadge) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(attributionUtilisateurBadge));
        Connexion.disconect();
    }

    @Override
    public void update(AttributionUtilisateurBadge attributionUtilisateurBadge) {
        Connexion.getPersistance();
        Connexion.em.merge(attributionUtilisateurBadge);
        Connexion.disconect();
    }

    @Override
    public List<AttributionUtilisateurBadge> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgeGetAll");
        List<AttributionUtilisateurBadge> attributionUtilisateurBadges = query.getResultList();
        Connexion.disconect();
        return attributionUtilisateurBadges;
    }

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgeCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public List<AttributionUtilisateurBadge> getAll(int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgeGetAll");
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<AttributionUtilisateurBadge> attributionUtilisateurBadges = query.getResultList();
        Connexion.disconect();
        return attributionUtilisateurBadges;
    }

    @Override
    public List<Badge> getBadgesNotAssign() {
       Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgeGetBadgesNotAssign");
        List<Badge> badges = query.getResultList();
        Connexion.disconect();
        return badges;
    }

    @Override
    public List<Badge> getBadgesNotAssign(int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgeGetBadgesNotAssign");
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Badge> badges = query.getResultList();
        Connexion.disconect();
        return badges;
    }
    
}
