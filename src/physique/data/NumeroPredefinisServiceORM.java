/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.NumeroPredefinis;

/**
 *
 * @author damien
 */
public interface NumeroPredefinisServiceORM {

    public void add(NumeroPredefinis numeroPredefinis);

    public void remove(NumeroPredefinis numeroPredefinis);

    public void update(NumeroPredefinis numeroPredefinis);

    public List<NumeroPredefinis> getAll();

    public Long count();

    public NumeroPredefinis getById(Long id);
}
