/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import java.awt.Event;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pierre
 */
public class DetecteurIntrusionServiceIOImpl extends Observable implements DetecteurIntrusionServiceIO, Runnable {

    SerialPortDriverRadio _portDriver = null;
    //public int i;
    public DetecteurIntrusionServiceIOImpl() {
    }

    public void creationPort() throws Exception {
        _portDriver = new SerialPortDriverRadio(this);
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
