/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPortEvent;
import java.util.Enumeration;

/**
 *
 * @author Pierre
 */
public interface DetecteurIntrusionServiceIO {

    public void fermerPortActuel() throws Exception;
    public Enumeration<CommPortIdentifier> getPortSerie() throws Exception;
    public void cycle() throws Exception;
    public String getNomPort() throws Exception;
    public void cyclePort() throws Exception;
    public void EcrireSurPortSerie(byte key) throws Exception;
    public boolean initIOStream() throws Exception;
    public void initListener() throws Exception;
    public String lire() throws Exception;
}
