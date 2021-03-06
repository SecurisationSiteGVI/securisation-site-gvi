/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public class SecteurServiceORMImpl implements SecteurServiceORM {

    @Override
    public void add(Secteur secteur) {
        Connexion.getPersistance();
        Connexion.em.persist(secteur);
        Connexion.disconect();
    }

    @Override
    public void remove(Secteur secteur) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(secteur));
        Connexion.disconect();
    }

    @Override
    public void update(Secteur secteur) {
        Connexion.getPersistance();
        Connexion.em.merge(secteur);
        Connexion.disconect();
    }

    @Override
    public List<Secteur> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("SecteurGetAll");
        List<Secteur> secteurs = query.getResultList();
        Connexion.disconect();
        return secteurs;
    }

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("SecteurCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public Secteur getById(Long id) {
        Connexion.getPersistance();
        Secteur secteur = Connexion.em.find(Secteur.class, id);
        Connexion.disconect();
        return secteur;
    }

    @Override
    public List<Secteur> getAll(int index, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("SecteurGetAll");
        query.setFirstResult(index);
        query.setMaxResults(nbResult);
        List<Secteur> secteurs = query.getResultList();
        Connexion.disconect();
        return secteurs;
    }
}
