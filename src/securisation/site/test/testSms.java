/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securisation.site.test;

import physique.io.PhysiqueIOFactory;

/**
 *
 * @author saturne
 */
public class testSms {
    
     public static void main(String[] args) throws Exception {
        // PhysiqueIOFactory.getSmsServiceIO().envoie("0646709709");
         PhysiqueIOFactory.getMailServiceIO().envoyer("alexiis.r27@gmail.com", "Sécurisation site GVI \n\nUn nouvel evenement à été crée, connectez-vous pour en savoir plus.", "Un nouvel evenement viens d'étre crée");
     }
}
