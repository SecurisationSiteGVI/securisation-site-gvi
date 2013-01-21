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
public class UtilisateurServiceORMImpl implements UtilisateurServiceORM {

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

    @Override
    public List<Utilisateur> getAllByRange(int debut,int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetAll");
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public List<Utilisateur> getByNom(String nom) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Utilisateur> getByNom(String nom, int debut, int nbResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Utilisateur> getByPrenom(String prenom) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Utilisateur> getByPrenom(String prenom, int debut, int nbResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Utilisateur> getByVille(String ville) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Utilisateur> getByVille(String ville, int debut, int nbResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Utilisateur> getByAdresse(String prenom) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Utilisateur> getByAdresse(String prenom, int debut, int nbResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Utilisateur> getByCodePostale(int code) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Utilisateur> getByCodePostale(int code, int debut, int nbResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Utilisateur> getByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Utilisateur> getByEmail(String email, int debut, int nbResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
