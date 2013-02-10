package metier;

import java.util.List;
import metier.entitys.AuthorisationAcces;
import metier.entitys.Secteur;
import metier.entitys.Utilisateur;

/**
 * @author 
 */
public interface AuthorisationAccesService {
    public void add(AuthorisationAcces authorisationAcces) throws Exception;
    public void update(AuthorisationAcces authorisationAcces) throws Exception;
    public void remove(AuthorisationAcces authorisationAcces) throws Exception;
    public List<AuthorisationAcces> getAll() throws Exception;
    public AuthorisationAcces getByUtilisateur(Utilisateur utilisateur)throws Exception;
    public void detacherSecteurFromUtilisateur(Secteur secteur, Utilisateur utilisateur);
    public void atacherSecteurFromUtilisateur(Secteur secteur, Utilisateur utilisateur);
    public List<Secteur> getSecteurNotAssignByUtilisateur(Utilisateur utilisateur);
    public Long count();
}
