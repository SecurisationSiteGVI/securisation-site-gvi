/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securisation.site.test;

import metier.entitys.Utilisateur;
import physique.data.PhysiqueDataFactory;

/**
 *
 * @author damien
 */
public class SecurisationSiteGvi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utilisateur u = new Utilisateur();
        u.setAdresse("adddre");
        u.setCodePostale(27930);
        u.setEmail("cdsd");
        u.setNom("d");
        u.setPrenom("sd");
      PhysiqueDataFactory.getUtilisateurServiceORM().add(u);        
    }
}
