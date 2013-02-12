package metier;

import java.util.List;
import metier.entitys.Position;

/**
 * @author 
 * @author
 * @author
 */

public interface PositionService {
    public void add(Position position) throws Exception;
    public void update(Position position) throws Exception;
    public void remove(Position position) throws Exception;
    public List<Position> getAll() throws Exception;
    public Long count();
}
