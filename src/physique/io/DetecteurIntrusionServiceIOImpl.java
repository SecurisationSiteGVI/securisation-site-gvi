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
        try {
        _portDriver = new SerialPortDriverRadio();
        _portDriver.open("/dev/ttyUSB0", 9600, 8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        System.out.println(_portDriver.getsPort());
        Thread t = new Thread(this);
        t.start();
        } catch(Exception e) {
            System.out.println("Carte detecteur grillage non connecté");
        }
    }

    @Override
    public void run() {
        try {
            String s = _portDriver.readLine();
            System.out.println("Information reçu " + s);
            PhysiqueIOFactory.getSmsServiceIO().creationPort();
            PhysiqueIOFactory.getSmsServiceIO().envoie(s);
        } catch (Exception ex) {
            Logger.getLogger(DetecteurIntrusionServiceIOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
