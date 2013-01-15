package metier;

import java.util.List;
import metier.entitys.Badge;

/**
 * @author 
 */
public interface BadgeService {
    public void add(Badge badge) throws Exception;
    public void update(Badge badge) throws Exception;
    public void remove(Badge badge) throws Exception;
    public List<Badge> getAll() throws Exception;
}
