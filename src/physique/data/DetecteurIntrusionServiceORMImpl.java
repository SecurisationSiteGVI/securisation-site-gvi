/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.DetecteurIntrusion;

/**
 *
 * @author damien
 */
public class DetecteurIntrusionServiceORMImpl implements DetecteurIntrusionServiceORM {

    @Override
    public void add(DetecteurIntrusion detecteurIntrusion) {
        Connexion.getPersistance();
        Connexion.em.persist(detecteurIntrusion);
        Connexion.disconect();
    }

    @Override
    public void remove(DetecteurIntrusion detecteurIntrusion) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(detecteurIntrusion));
        Connexion.disconect();
    }

    @Override
    public void update(DetecteurIntrusion detecteurIntrusion) {
        Connexion.getPersistance();
        Connexion.em.merge(detecteurIntrusion);
        Connexion.disconect();
    }

    @Override
    public List<DetecteurIntrusion> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("DetecteurIntrusionGetAll");
        List<DetecteurIntrusion> detecteurIntrusions = query.getResultList();
        Connexion.disconect();
        return detecteurIntrusions;
    }
    
    @Override
    public List<DetecteurIntrusion> getAll(int i, int nb) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("DetecteurIntrusionGetAll");
        query.setFirstResult(i);
        query.setMaxResults(nb);
        List<DetecteurIntrusion> detecteurIntrusions = query.getResultList();
        Connexion.disconect();
        return detecteurIntrusions;
    }

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("DetecteurIntrusionCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public DetecteurIntrusion getById(Long id) {
        Connexion.getPersistance();
        DetecteurIntrusion detecteurIntrusion = Connexion.em.find(DetecteurIntrusion.class, id);
        Connexion.disconect();
        return detecteurIntrusion;
    }
}
