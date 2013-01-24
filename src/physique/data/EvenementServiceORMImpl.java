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
    public List<Evenement> getByPhoto() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("PhotoGetAll");
        List<Evenement> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Evenement> getByPhoto(int debut, int nbResut) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("PhotoGetAll");
        query.setFirstResult(debut);
        query.setMaxResults(nbResut);
        List<Evenement> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Evenement> getByAcces() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AccesGetAll");
        List<Evenement> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Evenement> getByAcces(int debut, int nbResut) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AccesGetAll");
        query.setFirstResult(debut);
        query.setMaxResults(nbResut);
        List<Evenement> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Evenement> getByIntrusion() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("IntrusionGetAll");
        List<Evenement> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }

    @Override
    public List<Evenement> getByIntrusion(int debut, int nbResut) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("IntrusionGetAll");
        query.setFirstResult(debut);
        query.setMaxResults(nbResut);
        List<Evenement> evenements = query.getResultList();
        Connexion.disconect();
        return evenements;
    }
}
