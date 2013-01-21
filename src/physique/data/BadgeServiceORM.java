/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.Badge;

/**
 *
 * @author damien
 */
public interface BadgeServiceORM {

    public void add(Badge badge);

    public void remove(Badge badge);

    public void update(Badge badge);

    public Long count();

    public List<Badge> getAll();
}
