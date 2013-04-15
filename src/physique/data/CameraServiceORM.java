/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.Camera;

/**
 *
 * @author damien
 */
public interface CameraServiceORM {

    public void add(Camera camera);

    public void remove(Camera camera);

    public void update(Camera camera);

    public List<Camera> getAll();
    public List<Camera> getAll(int index,int nbResult);
    public Long count();

    public Camera getById(Long id);
}
