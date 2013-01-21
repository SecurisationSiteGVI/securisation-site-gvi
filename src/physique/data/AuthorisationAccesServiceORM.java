/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.AuthorisationAcces;

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
}
