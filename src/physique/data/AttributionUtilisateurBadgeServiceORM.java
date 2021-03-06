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

    public AttributionUtilisateurBadge getByUtilisateur(Utilisateur utilisateur);

    public List<AttributionUtilisateurBadge> getAll();

    public List<AttributionUtilisateurBadge> getAll(int debut, int nbResult);

    public List<Badge> getBadgesNotAssign();

    public List<Badge> getBadgesNotAssign(int debut, int nbResult);

    public List<Utilisateur> getUtilisateurNotAssign();

    public List<Utilisateur> getUtilisateurNotAssign(int debut, int nbResult);

    public List<Utilisateur> getUtilisateurNotAssignByNom(String nom);

    public List<Utilisateur> getUtilisateurNotAssignByNom(String nom, int debut, int nbResult);

    public List<Badge> getBadgesNotAssignByNumero(String numero);

    public AttributionUtilisateurBadge getById(Long id);

    public AttributionUtilisateurBadge getByBadge(Badge badge);

    public List<Badge> getBadgesNotAssignByNumero(String numero, int debut, int nbResult);
}
