/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author damien
 */
public class Connexion {

    private static EntityManagerFactory emf;
    protected static EntityManager em;
    private static EntityTransaction tx;

    protected static void getPersistance() {
        try {
            emf = Persistence.createEntityManagerFactory("securisation-site-gviPU");
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
        } catch (Exception ex) {
            System.out.println("Probleme de connexion à la base de donnée " + ex);
        }
    }

    protected static void disconect() {
        try {
            tx.commit();
            em.close();
            emf.close();
        } catch (Exception ex) {
            System.out.println("Probleme de déconnexion à la base de donnee " + ex.getMessage());
        }
    }
}
