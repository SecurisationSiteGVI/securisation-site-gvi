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
    public List<Evenement> getAll(int debut, int nbResut);
    public List<Evenement> getByPhoto();
    public List<Evenement> getByPhoto(int debut, int nbResut);
    public List<Evenement> getByAcces();
    public List<Evenement> getByAcces(int debut, int nbResut);
    public List<Evenement> getByIntrusion();
    public List<Evenement> getByIntrusion(int debut, int nbResut);
}
