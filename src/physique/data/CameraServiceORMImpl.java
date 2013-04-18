/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.Camera;
import metier.entitys.Position;

/**
 *
 * @author damien
 */
public class CameraServiceORMImpl implements CameraServiceORM {

    @Override
    public void add(Camera camera) {
        Connexion.getPersistance();
        Connexion.em.persist(camera);
        Connexion.disconect();
    }

    @Override
    public void remove(Camera camera) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(camera));
        Connexion.disconect();
    }

    @Override
    public void update(Camera camera) {
        Connexion.getPersistance();
        Connexion.em.merge(camera);
        Connexion.disconect();
    }

    @Override
    public List<Camera> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("cameraGetAll");
        List<Camera> cameras = query.getResultList();
        Connexion.disconect();
        return cameras;
    }

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("CameraCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public Camera getById(Long id) {
        Connexion.getPersistance();
        Camera camera = Connexion.em.find(Camera.class, id);
        Connexion.disconect();
        return camera;
    }

    @Override
    public List<Camera> getAll(int index, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("cameraGetAll");
        query.setFirstResult(index);
        query.setMaxResults(nbResult);
        List<Camera> cameras = query.getResultList();
        Connexion.disconect();
        return cameras;
    }

    @Override
    public List<Camera> getByPosition(Position position) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("CameraByPosition");
        query.setParameter("id", position.getId());
        List<Camera> cameras = query.getResultList();
        Connexion.disconect();
        return cameras;
    }
}
