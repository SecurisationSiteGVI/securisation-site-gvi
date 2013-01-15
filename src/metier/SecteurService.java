package metier;

import java.util.List;
import metier.entitys.Secteur;

/**
 * @author 
 * @author
 * @author
 */

public interface SecteurService {
    public void add(Secteur secteur) throws Exception;
    public void update(Secteur secteur) throws Exception;
    public void remove(Secteur secteur) throws Exception;
    public List<Secteur> getAll() throws Exception;
}
