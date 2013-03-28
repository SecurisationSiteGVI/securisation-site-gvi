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
         PhysiqueIOFactory.getSmsServiceIO().creationPort();
         PhysiqueIOFactory.getSmsServiceIO().envoieNumero("0646709709");
     }
}
