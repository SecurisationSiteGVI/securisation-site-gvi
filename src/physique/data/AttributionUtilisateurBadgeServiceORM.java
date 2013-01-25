/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.AttributionUtilisateurBadge;
import metier.entitys.Badge;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
public interface AttributionUtilisateurBadgeServiceORM {

    public void add(AttributionUtilisateurBadge attributionUtilisateurBadge);

    public void remove(AttributionUtilisateurBadge attributionUtilisateurBadge);

    public void update(AttributionUtilisateurBadge attributionUtilisateurBadge);

    public Long count();

    public List<AttributionUtilisateurBadge> getAll();
    public List<AttributionUtilisateurBadge> getAll(int debut, int nbResult);
    public List<Badge> getBadgesNotAssign();
    public List<Badge> getBadgesNotAssign(int debut, int nbResult);
    public List<Utilisateur> getUtilisateurNotAssign();
    public List<Utilisateur> getUtilisateurNotAssign(int debut, int nbResult);
}
