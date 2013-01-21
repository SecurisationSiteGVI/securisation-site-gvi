/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.DetecteurIntrusion;

/**
 *
 * @author damien
 */
public interface DetecteurIntrusionServiceORM {

    public void add(DetecteurIntrusion detecteurIntrusion);

    public void remove(DetecteurIntrusion detecteurIntrusion);

    public void update(DetecteurIntrusion detecteurIntrusion);
public Long count();
    public List<DetecteurIntrusion> getAll();
}
