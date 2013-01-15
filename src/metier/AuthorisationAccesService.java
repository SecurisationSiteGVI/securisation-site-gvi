package metier;

import java.util.List;
import metier.entitys.AuthorisationAcces;

/**
 * @author 
 */
public interface AuthorisationAccesService {
    public void add(AuthorisationAcces authorisationAcces) throws Exception;
    public void update(AuthorisationAcces authorisationAcces) throws Exception;
    public void remove(AuthorisationAcces authorisationAcces) throws Exception;
    public List<AuthorisationAcces> getAll() throws Exception;
}
