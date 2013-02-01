/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import metier.entitys.AttributionUtilisateurBadge;
import metier.entitys.Badge;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
public class AttributionUtilisateurBadgeServiceORMImpl implements AttributionUtilisateurBadgeServiceORM {

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

    @Override
    public List<Utilisateur> getUtilisateurNotAssign() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgeGetUtilisateurNotAssign");
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getUtilisateurNotAssign(int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgeGetUtilisateurNotAssign");
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getUtilisateurNotAssignByNom(String nom) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgeGetUtilisateurNotAssignByNom");
        query.setParameter("nom", nom);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getUtilisateurNotAssignByNom(String nom, int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgeGetUtilisateurNotAssignByNom");
        query.setParameter("nom", nom);
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public AttributionUtilisateurBadge getByUtilisateur(Utilisateur utilisateur) {
        AttributionUtilisateurBadge attributionUtilisateurBadge = null;
        try {
            Connexion.getPersistance();
            Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgegetByUtilisateur");
            query.setParameter("id", utilisateur.getId());
            attributionUtilisateurBadge = (AttributionUtilisateurBadge) query.getSingleResult();
            Connexion.disconect();
        } catch (NoResultException e) {
            System.out.println("Pas de resultat dans la bdd" + e);
        }

        return attributionUtilisateurBadge;
    }

    @Override
    public List<Badge> getBadgesNotAssignByNumero(int numero) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgeGetBadgesNotAssignByNumero");
        query.setParameter("numero", numero);
        List<Badge> badges = query.getResultList();
        Connexion.disconect();
        return badges;
    }

    @Override
    public List<Badge> getBadgesNotAssignByNumero(int numero, int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AttributionUtilisateurBadgeGetBadgesNotAssignByNumero");
        query.setParameter("numero", numero);
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Badge> badges = query.getResultList();
        Connexion.disconect();
        return badges;
    }
}
