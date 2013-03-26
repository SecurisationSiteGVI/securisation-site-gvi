/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import physique.io.DetecteurIntrusionServiceIO;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import physique.io.BorneAccesServiceIO;

/**
 *
 * @author Pierre
 */
public class DetecteurIntrusionServiceIOImpl extends Observable implements DetecteurIntrusionServiceIO, Runnable {

    SerialPortDriver _portDriver = null;

    public DetecteurIntrusionServiceIOImpl() {
    }

    public void creationPort() throws Exception {
        _portDriver = new SerialPortDriver(this);
        System.out.println(_portDriver.getPortName());
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            if (_portDriver.initIOStream() == true) {
                _portDriver.initListener();
            }
        } catch (Exception ex) {
            Logger.getLogger(DetecteurIntrusionServiceIOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
