package physique.io;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPortEvent;
import java.util.Enumeration;

/**
 *
 * @author Pierre
 */
public interface DetecteurIntrusionServiceIO {

    public void creationPort() throws Exception;
}
