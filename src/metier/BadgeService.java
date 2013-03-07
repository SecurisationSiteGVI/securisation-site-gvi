package metier;

import java.util.List;
import metier.entitys.Badge;

/**
 * @author damien
 */
public interface BadgeService {

    public void add(Badge badge) throws Exception;

    public void update(Badge badge) throws Exception;

    public void remove(Badge badge) throws Exception;

    public List<Badge> getAll() throws Exception;

    public List<Badge> getAll(int debut, int nbResult) throws Exception;

    public Long count();

    public Badge getById(Long id);
    
    public Badge getByNumero(String numero);
}
