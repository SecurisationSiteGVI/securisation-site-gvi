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

    public void EcrireSurPortSerie(byte key) throws Exception;
    public String lire() throws Exception;
}
