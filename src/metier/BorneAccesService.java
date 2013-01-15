package metier;

import java.util.List;
import metier.entitys.BorneAcces;

/**
 *
 * @author ragotalexis
 */
public interface BorneAccesService {
    public void add(BorneAcces borneAcces) throws Exception;
    public void update(BorneAcces borneAcces) throws Exception;
    public void remove(BorneAcces borneAcces) throws Exception;
    public List<BorneAcces> getAll() throws Exception;
}
