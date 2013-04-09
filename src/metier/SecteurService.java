package metier;

import java.util.List;
import metier.entitys.Secteur;

/**
 * @author damien
 */
public interface SecteurService {

    public void add(Secteur secteur) throws Exception;

    public void update(Secteur secteur) throws Exception;

    public void remove(Secteur secteur) throws Exception;

    public List<Secteur> getAll() throws Exception;

    public Long count();
public List<Secteur> getAll(int index, int nbResult);
    public Secteur getById(Long id);
}
