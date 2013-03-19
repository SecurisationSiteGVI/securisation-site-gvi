/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import gnu.io.SerialPortEvent;

/**
 *
 * @author Pierre
 */
public interface DetecteurIntrusionServiceIO {

    public void rechercheDePorts() throws Exception;

    public void evenementSerie(SerialPortEvent evt) throws Exception;

    public void connexion() throws Exception;

    public void envoyerGrillage(String grillage) throws Exception;

    public void setConnected(boolean bConnected) throws Exception;

    public void getConnected() throws Exception;

    public boolean initIOStream() throws Exception;

    public void initListener() throws Exception;

    public void deconnexion() throws Exception;
}
