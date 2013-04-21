package metier;

import java.util.List;
import metier.entitys.BorneAcces;
import metier.entitys.Position;

/**
 * @author damien
 * @author ragotalexis
 */
public interface BorneAccesService {

    public void add(BorneAcces borneAcces) throws Exception;

    public void update(BorneAcces borneAcces) throws Exception;

    public void remove(BorneAcces borneAcces) throws Exception;

    public List<BorneAcces> getAll() throws Exception;

    public Long count();

    public BorneAcces getById(Long id);

    public void startThread();

    public void verificationAcces() throws Exception;

    public List<BorneAcces> getByPosition(Position position);

    public BorneAcces getByNom(String nom);

    public List<BorneAcces> getAll(int index, int nbResult);
}
