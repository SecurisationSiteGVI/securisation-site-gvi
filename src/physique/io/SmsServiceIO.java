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
    
    public void rechercheDePort();
    public void envoyerGrillage(String grillage);
    public void connexion();
    public void setConnexion(boolean bConnected);
    public boolean getConnexion();
    public boolean initIOStream();
    public void initListener();
    public void disconnect();
    
}
