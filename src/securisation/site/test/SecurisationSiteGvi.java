/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securisation.site.test;

import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import java.util.List;
import metier.entitys.Administrateur;
import metier.entitys.Technicien;
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
        List<Technicien> u = PhysiqueDataFactory.getUtilisateurServiceORM().getByLogin("damienChes");
        System.out.println(u);
    }
}
