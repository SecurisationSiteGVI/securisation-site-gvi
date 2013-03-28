/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import gnu.io.SerialPort;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pierre
 */
public class SmsServiceIOImpl implements SmsServiceIO, Runnable {

    SerialPortDriverUsb _portDriver = null;

    public SmsServiceIOImpl() {
    }

    @Override
    public void creationPort() throws Exception {
        try {
            _portDriver = new SerialPortDriverUsb(this);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Carte d'envoie sms non connecté");
        }
    }

    @Override
    public void envoieNumero(String numero) throws Exception {
        
        _portDriver.writeToSerial(numero);
        System.out.println("Envoit du message au numéro " + numero);
        run();
    }
    
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
