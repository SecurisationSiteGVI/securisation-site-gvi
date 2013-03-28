/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import metier.MetierFactory;
import metier.entitys.BorneAcces;

/**
 *
 * @author ragotalexis
 */
public class test {

    public static void main(String[] args) throws Exception {
        MetierFactory.getBorneAccesService().startThread();
//        BorneAccesServiceIOImpl borneAccesServiceIOImpl = new BorneAccesServiceIOImpl();
//        borneAccesServiceIOImpl.getTrame();
    }
}