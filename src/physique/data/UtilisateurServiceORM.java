/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import metier.entitys.Administrateur;
import metier.entitys.Technicien;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
public interface UtilisateurServiceORM {

    public void add(Utilisateur utilisateur);

    public void remove(Utilisateur utilisateur);

    public void update(Utilisateur utilisateur);

    public List<Utilisateur> getAll();
    public List<Utilisateur> getAllByRange(int debut,int fin);
    public List<Technicien> getByLogin(String login);
    public int count();
}
