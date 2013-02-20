package metier;

import java.util.List;
import metier.entitys.AttributionUtilisateurBadge;
import metier.entitys.Badge;
import metier.entitys.Utilisateur;

/**
 * @author
 */
public interface AttributionUtilisateurBadgeService {

    public void add(AttributionUtilisateurBadge attributionUtilisateurBadge) throws Exception;

    public void update(AttributionUtilisateurBadge attributionUtilisateurBadge) throws Exception;

    public void remove(AttributionUtilisateurBadge attributionUtilisateurBadge) throws Exception;

    public List<AttributionUtilisateurBadge> getAll() throws Exception;

    public List<AttributionUtilisateurBadge> getAll(int debut, int nbResult);

    public List<Badge> getBadgesNotAssign();

    public List<Badge> getBadgesNotAssign(int debut, int nbResult);

    public List<Utilisateur> getUtilisateurNotAssign();

    public List<Utilisateur> getUtilisateurNotAssign(int debut, int nbResult);

    public List<Utilisateur> getUtilisateurNotAssignByNom(String nom);

    public List<Utilisateur> getUtilisateurNotAssignByNom(String nom, int debut, int nbResult);

    public AttributionUtilisateurBadge getByUtilisateur(Utilisateur utilisateur);

    public List<Badge> getBadgesNotAssignByNumero(int numero);

    public List<Badge> getBadgesNotAssignByNumero(int numero, int debut, int nbResult);

    public Long count();

    public AttributionUtilisateurBadge getById(Long id);
}
