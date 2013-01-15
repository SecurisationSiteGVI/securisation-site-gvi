/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.Position;

/**
 *
 * @author damien
 */
public interface PositionServiceORM {
    public void add(Position position);
    public void remove(Position position);
    public void update(Position position);
    public List<Position> getAll();
}
