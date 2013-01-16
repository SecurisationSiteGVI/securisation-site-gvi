/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
public interface UtilisateurService {
    public void add(Utilisateur utilisateur);

    public void remove(Utilisateur utilisateur);

    public void update(Utilisateur utilisateur);

    public List<Utilisateur> getAll();
}
