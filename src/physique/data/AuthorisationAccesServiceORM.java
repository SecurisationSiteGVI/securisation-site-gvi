/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.AuthorisationAcces;
import metier.entitys.Badge;

/**
 *
 * @author damien
 */
public interface AuthorisationAccesServiceORM {

    public void add(AuthorisationAcces authorisationAcces);

    public void remove(AuthorisationAcces authorisationAcces);

    public void update(AuthorisationAcces authorisationAcces);

    public Long count();

    public List<AuthorisationAcces> getAll();
    public List<AuthorisationAcces> getAll(int debut, int nbResult);
    public List<Badge> getBadgesNotAssign();
    public List<Badge> getBadgesNotAssign(int debut, int nbResult);
}
