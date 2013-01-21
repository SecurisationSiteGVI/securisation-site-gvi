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
public class DetecteurIntrusionServiceORMImpl implements DetecteurIntrusionServiceORM{

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
    public Long count() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
