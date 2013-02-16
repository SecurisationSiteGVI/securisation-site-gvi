/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import metier.entitys.Technicien;
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
    public boolean loginIsUtilise(String login) ;
    public Technicien verifificationConnexion(String login, String password);
    public List<Technicien> getByLogin(String login);
    public List<Utilisateur> getAllByRange(int debut,int fin);
    public Long count();
    public List<Utilisateur> getByNom(String nom);
    public List<Utilisateur> getByNom(String nom,int debut,int nbResult);
    public List<Utilisateur> getByPrenom(String prenom);
    public List<Utilisateur> getByPrenom(String prenom,int debut,int nbResult);
    public List<Utilisateur> getByVille(String ville);
    public List<Utilisateur> getByVille(String ville,int debut,int nbResult);
    public List<Utilisateur> getByAdresse(String adresse);
    public List<Utilisateur> getByAdresse(String adresse,int debut,int nbResult);
    public List<Utilisateur> getByCodePostale(int code);
    public List<Utilisateur> getByCodePostale(int code,int debut,int nbResult);
    public List<Utilisateur> getByEmail(String email);
    public List<Utilisateur> getByEmail(String email,int debut,int nbResult);
    public Utilisateur getById(Long id);
    
}
