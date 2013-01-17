/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.NumeroPredefinis;

/**
 *
 * @author damien
 */
public interface NumeroPredefinisService {
    public void add(NumeroPredefinis numeroPredefinis) throws Exception;
    public void update(NumeroPredefinis numeroPredefinis) throws Exception;
    public void remove(NumeroPredefinis numeroPredefinis) throws Exception;
    public List<NumeroPredefinis> getAll() throws Exception;
}
