package metier;

import java.util.List;
import metier.entitys.AttributionUtilisateurBadge;

/**
 * @author 
 */
public interface AttributionUtilisateurBadgeService {
    public void add(AttributionUtilisateurBadge attributionUtilisateurBadge) throws Exception;
    public void update(AttributionUtilisateurBadge attributionUtilisateurBadge) throws Exception;
    public void remove(AttributionUtilisateurBadge attributionUtilisateurBadge) throws Exception;
    public List<AttributionUtilisateurBadge> getAll() throws Exception;
}
