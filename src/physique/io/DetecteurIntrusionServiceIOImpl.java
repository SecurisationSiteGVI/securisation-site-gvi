/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import gnu.io.SerialPort;
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
        _portDriver = new SerialPortDriverRadio();
        _portDriver.open("/dev/ttyUSB0", 9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_2, SerialPort.PARITY_EVEN);
        System.out.println(_portDriver.getsPort());
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            String s = _portDriver.readLine();
        } catch (Exception ex) {
            Logger.getLogger(DetecteurIntrusionServiceIOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
