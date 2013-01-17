/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.List;
import javax.persistence.Query;
import metier.entitys.Administrateur;
import metier.entitys.Technicien;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
public class UtilisateurServiceORMImpl implements UtilisateurServiceORM{

    @Override
    public void add(Utilisateur utilisateur) {
        Connexion.getPersistance();
        Connexion.em.persist(utilisateur);
        Connexion.disconect();
    }

    @Override
    public void remove(Utilisateur utilisateur) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(utilisateur));
        Connexion.disconect();
    }

    @Override
    public void update(Utilisateur utilisateur) {
        Connexion.getPersistance();
        Connexion.em.merge(utilisateur);
        Connexion.disconect();
    }

    @Override 
    public List<Utilisateur> getAll() { 
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetAll");
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Technicien> getByLogin(String login) { 
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("TechnicienGetByLogin");
        query.setParameter("login", login);
        List<Technicien> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }
    
}
