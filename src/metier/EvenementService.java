package metier;

import java.util.List;
import metier.entitys.Acces;
import metier.entitys.Evenement;
import metier.entitys.Intrusion;
import metier.entitys.Photo;

/**
 * @author damien
 * @author
 * @author
 */
public interface EvenementService {

    public void add(Evenement evenement) throws Exception;

    public void update(Evenement evenement) throws Exception;

    public void remove(Evenement evenement) throws Exception;

    public List<Evenement> getAll() throws Exception;

    public List<Evenement> getAll(int debut, int nbResut);

    public List<Photo> getByPhoto();

    public List<Photo> getByPhoto(int debut, int nbResut);

    public List<Acces> getByAcces();

    public List<Acces> getByAcces(int debut, int nbResut);

    public List<Intrusion> getByIntrusion();

    public List<Intrusion> getByIntrusion(int debut, int nbResut);

    public Long count();

    public Evenement getById(Long id);
}
