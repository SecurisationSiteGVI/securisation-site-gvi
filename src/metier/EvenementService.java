package metier;

import java.util.List;
import metier.entitys.Evenement;

/**
 * @author 
 * @author 
 * @author 
 */

public interface EvenementService {
    public void add(Evenement evenement) throws Exception;
    public void update(Evenement evenement) throws Exception;
    public void remove(Evenement evenement) throws Exception;
    public List<Evenement> getAll() throws Exception;
}
