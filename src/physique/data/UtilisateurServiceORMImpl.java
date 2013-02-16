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
        utilisateur = Connexion.em.merge(utilisateur);
        Connexion.em.remove(utilisateur);
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
        Connexion.disconect();
        return i;
    }

    @Override
    public List<Utilisateur> getByNom(String nom) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByNom");
        query.setParameter("nom", nom);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByNom(String nom, int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByNom");
        query.setParameter("nom", nom);
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByPrenom(String prenom) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByPrenom");
        query.setParameter("prenom", prenom);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByPrenom(String prenom, int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByPrenom");
        query.setParameter("prenom", prenom);
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByVille(String ville) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByVille");
        query.setParameter("ville", ville);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByVille(String ville, int debut, int nbResult) {
       Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByVille");
        query.setParameter("ville", ville);
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByAdresse(String adresse) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByAdresse");
        query.setParameter("adresse", adresse);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByAdresse(String adresse, int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByAdresse");
        query.setParameter("adresse", adresse);
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByCodePostale(int code) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByCodePostale");
        query.setParameter("codePostale", code);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByCodePostale(int code, int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByCodePostale");
        query.setParameter("codePostale", code);
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByEmail(String email) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByEmail");
        query.setParameter("email", email);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public List<Utilisateur> getByEmail(String email, int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("UtilisateurGetByEmail");
        query.setParameter("email", email);
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<Utilisateur> utilisateurs = query.getResultList();
        Connexion.disconect();
        return utilisateurs;
    }

    @Override
    public Utilisateur getById(Long id) {
        Connexion.getPersistance();
        Utilisateur u = Connexion.em.find(Utilisateur.class, id);
        Connexion.disconect();
        return u;
    }
}
