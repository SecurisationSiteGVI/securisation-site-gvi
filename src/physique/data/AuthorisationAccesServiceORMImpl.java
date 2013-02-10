/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import metier.entitys.AuthorisationAcces;
import metier.entitys.Badge;
import metier.entitys.Secteur;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
public class AuthorisationAccesServiceORMImpl implements AuthorisationAccesServiceORM {

    @Override
    public void add(AuthorisationAcces authorisationAcces) {
        Connexion.getPersistance();
        Connexion.em.persist(authorisationAcces);
        Connexion.disconect();
    }

    @Override
    public void remove(AuthorisationAcces authorisationAcces) {
        Connexion.getPersistance();
        Connexion.em.remove(Connexion.em.merge(authorisationAcces));
        Connexion.disconect();
    }

    @Override
    public void update(AuthorisationAcces authorisationAcces) {
        Connexion.getPersistance();
        Connexion.em.merge(authorisationAcces);
        Connexion.disconect();
    }

    @Override
    public List<AuthorisationAcces> getAll() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AuthorisationAccesGetAll");
        List<AuthorisationAcces> authorisationAcceses = query.getResultList();
        Connexion.disconect();
        return authorisationAcceses;
    }

    @Override
    public Long count() {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AuthorisationAccesCount");
        Long i = (Long) query.getSingleResult();
        System.out.println(i);
        Connexion.disconect();
        return i;
    }

    @Override
    public List<AuthorisationAcces> getAll(int debut, int nbResult) {
        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AuthorisationAccesGetAll");
        query.setFirstResult(debut);
        query.setMaxResults(nbResult);
        List<AuthorisationAcces> authorisationAcceses = query.getResultList();
        Connexion.disconect();
        return authorisationAcceses;
    }

    @Override
    public AuthorisationAcces getByUtilisateur(Utilisateur utilisateur) {
        AuthorisationAcces authorisationAcceses = null;
        try {
            Connexion.getPersistance();
            Query query = Connexion.em.createNamedQuery("AuthorisationAccesGetByUtilisateur");
            query.setParameter("id", utilisateur.getId());
            authorisationAcceses = (AuthorisationAcces) query.getSingleResult();

            Connexion.disconect();
        } catch (NoResultException e) {
            System.out.println("Pas de resultat dans la bdd" + e);
        }
        return authorisationAcceses;
    }

    @Override
    public List<Secteur> getSecteurNotAssignByUtilisateur(Utilisateur utilisateur) {
        List<Secteur> secteursALL = PhysiqueDataFactory.getSecteurServiceORM().getAll();

        Connexion.getPersistance();
        Query query = Connexion.em.createNamedQuery("AuthorisationAccesGetByUtilisateur");
        query.setParameter("id", utilisateur.getId());
        List<AuthorisationAcces> authorisationAcceses = query.getResultList();
        List<Secteur> secteursUtilisateur = new ArrayList<>();
        if (!authorisationAcceses.isEmpty()) {
            secteursUtilisateur = authorisationAcceses.get(0).getSecteurs();
        }
        if (!secteursUtilisateur.isEmpty()) {
            for (int i = 0; i < secteursALL.size(); i++) {
                if (secteursUtilisateur.size() >= i) {
                    Long idSecteur = secteursALL.get(i).getId();
                    for (int j = 0; j < secteursALL.size(); j++) {
                        if(secteursALL.get(j).getId().equals(idSecteur)){
                            secteursALL.remove(j);
                        }
                    }
                  
                }
            }
        }
        Connexion.disconect();
        return secteursALL;
    }
}
