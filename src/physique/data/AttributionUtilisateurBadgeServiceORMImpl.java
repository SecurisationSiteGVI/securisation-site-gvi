/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.AttributionUtilisateurBadge;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
