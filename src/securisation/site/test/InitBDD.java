/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securisation.site.test;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.MetierFactory;
import metier.UtilisateurService;
import metier.entitys.Administrateur;
import metier.entitys.Badge;
import metier.entitys.BorneAcces;
import metier.entitys.Position;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
public class InitBDD {
    private UtilisateurService utilisateurSrv = MetierFactory.getUtilisateurService();
    private InitBDD(){}
    public InitBDD(Boolean initAdministrateur,Boolean initUtilisateur,Boolean initbadges,Boolean initBorneAcces){
        if(initAdministrateur){
            this.initAdministrateur();
        }
        if(initUtilisateur){
            this.initUtilisateurs();
        }
        if(initbadges){
            this.initBadges();
        }
        if(initBorneAcces){
            this.initBorneAcces();
        }
    }
    private void initBorneAcces(){
        Position p = new Position();
        p.setLongitude(48.855334);
        p.setLatitude(2.367656);
        try {
            MetierFactory.getPositionService().add(p);
        } catch (Exception ex) {
            Logger.getLogger(InitBDD.class.getName()).log(Level.SEVERE, null, ex);
        }Position position = null;
        try {
             position= MetierFactory.getPositionService().getAll().get(0);
        } catch (Exception ex) {
            Logger.getLogger(InitBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i =0 ;i <3 ;i++){
            BorneAcces b = new BorneAcces();
            b.setEntrer(Boolean.TRUE);
            b.setNom("Lecteur de badge n°"+i+1);
            b.setPosition(position);
            try {
                MetierFactory.getBorneAccesService().add(b);
            } catch (Exception ex) {
                Logger.getLogger(InitBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    private void initAdministrateur(){
        Administrateur u = new Administrateur();
        u.setNom("Chesneau");//
        u.setPrenom("Damien");
        u.setLogin("damienChes");
        u.setPassword("damien");
        u.encode(true);
        utilisateurSrv.add(u);
    }
    private void initUtilisateurs(){
        for (int i = 0; i < 5000; i++) {
            Utilisateur u = new Utilisateur();
            u.setNom("Chesneau"+i);//
            u.setPrenom("Damien"+i);
            u.setAdresse(i+" rue du truc");
            u.setHomme(true);
            u.setCodePostale(27000);
            u.setVille("Evreux"+i);
            utilisateurSrv.add(u);
            u.setDateDeNaissance(new Date());
            u.setTelephoneFixe("0232325252");
            u.setTelephonePortable("0632325252");
            utilisateurSrv.add(u);
        }
        System.out.println(utilisateurSrv.count());
    }
    private void initBadges(){
        for(int i =0 ; i<500 ; i++){
            Badge badge = new Badge();
            badge.setNumero(54786+i);
            try {         
                MetierFactory.getBadgeService().add(badge);
            } catch (Exception ex) {
                Logger.getLogger(InitBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
