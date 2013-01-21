/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.AttributionUtilisateurBadge;

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
}
