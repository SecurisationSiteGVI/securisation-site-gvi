/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.Acces;
import metier.entitys.DetecteurIntrusion;
import metier.entitys.Evenement;
import metier.entitys.Intrusion;
import metier.entitys.Photo;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
public class EvenementServiceORMImpl implements EvenementServiceORM {

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

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("EvenementCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public List<Evenement> getAll(int debut, int nbResut) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("EvenementGetAll");
        query.setFirstResult(debut);
        query.setMaxResults(nbResut);
        List<Evenement> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Photo> getByPhoto() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("PhotoGetAll");
        List<Photo> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Photo> getByPhoto(int debut, int nbResut) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("PhotoGetAll");
        query.setFirstResult(debut);
        query.setMaxResults(nbResut);
        List<Photo> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Acces> getByAcces() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AccesGetAll");
        List<Acces> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Acces> getByAcces(int debut, int nbResut) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AccesGetAll");
        query.setFirstResult(debut);
        query.setMaxResults(nbResut);
        List<Acces> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Intrusion> getByIntrusion() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("IntrusionGetAll");
        List<Intrusion> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Intrusion> getByIntrusion(int debut, int nbResut) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("IntrusionGetAll");
        query.setFirstResult(debut);
        query.setMaxResults(nbResut);
        List<Intrusion> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public Evenement getById(Long id) {
        Connexion.getPersistance();
        Evenement evenement = Connexion.em.find(Evenement.class, id);
        Connexion.disconect();
        return evenement;
    }

    @Override
    public List<Evenement> getByMostRecent() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("EvenementGetMostRecent");
        List<Evenement> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Evenement> getByMostRecent(int debut, int nbResut) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("EvenementGetMostRecent");
        query.setFirstResult(debut);
        query.setMaxResults(nbResut);
        List<Evenement> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Acces> getAccesByUtilisateur(Utilisateur utilisateur) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AccesGetByUtilisateur");
        query.setParameter("id", utilisateur.getId());
        List<Acces> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }
}
