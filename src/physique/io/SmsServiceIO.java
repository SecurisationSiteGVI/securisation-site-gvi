/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

/**
 *
 * @author Pierre
 */
public interface SmsServiceIO {
    public void creationPort() throws Exception;
    public void envoie(String tel, String grillage) throws Exception;
}
