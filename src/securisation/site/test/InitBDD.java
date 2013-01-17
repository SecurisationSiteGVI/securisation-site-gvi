/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securisation.site.test;

import metier.MetierFactory;
import metier.UtilisateurService;
import metier.entitys.Administrateur;

/**
 *
 * @author damien
 */
public class InitBDD {
    private UtilisateurService utilisateurSrv = MetierFactory.getUtilisateurService();
    private InitBDD(){}
    public InitBDD(Boolean initUtilisateur){
        if(initUtilisateur){
            this.initUilisateurs();
        }
    }
    private void initUilisateurs(){
        Administrateur u = new Administrateur();
        u.setNom("Chesneau");
        u.setPrenom("Damien");
        u.setLogin("damienChes");
        u.setPassword("damien");
        u.encode(true);
        utilisateurSrv.add(u);
    }
}
