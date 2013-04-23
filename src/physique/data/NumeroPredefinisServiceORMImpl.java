/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.awt.geom.QuadCurve2D;
import java.util.List;
import javax.persistence.Query;
import metier.entitys.NumeroPredefinis;

/**
 *
 * @author damien
 */
public class NumeroPredefinisServiceORMImpl implements NumeroPredefinisServiceORM {

    @Override
    public void add(NumeroPredefinis numeroPredefinis) {
        Connexion.getPersistance();
        Connexion.em.persist(numeroPredefinis);
        Connexion.disconect();
    }

    @Override
    public void remove(NumeroPredefinis numeroPredefinis) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(numeroPredefinis));
        Connexion.disconect();
    }

    @Override
    public void update(NumeroPredefinis numeroPredefinis) {
        Connexion.getPersistance();
        Connexion.em.merge(numeroPredefinis);
        Connexion.disconect();
    }

    @Override
    public List<NumeroPredefinis> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("NumeroPredefinisGetAll");
        List<NumeroPredefinis> numeroPredefinis = query.getResultList();
        Connexion.disconect();
        return numeroPredefinis;
    }

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("NumeroPredefinisCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public NumeroPredefinis getById(Long id) {
        Connexion.getPersistance();
        NumeroPredefinis numeroPredefinis = Connexion.em.find(NumeroPredefinis.class, id);
        Connexion.disconect();
        return numeroPredefinis;
    }

    @Override
    public List<NumeroPredefinis> getAll(int index, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("NumeroPredefinisGetAll");
        query.setFirstResult(index);
        query.setMaxResults(nbResult);
        List<NumeroPredefinis> numeroPredefinis = query.getResultList();
        Connexion.disconect();
        return numeroPredefinis;
    }
}
