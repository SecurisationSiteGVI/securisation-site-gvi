/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

/**
 *
 * @author damien
 */
public interface MailServiceIO {
    public boolean envoyer(String email, String message,String objet);
}
