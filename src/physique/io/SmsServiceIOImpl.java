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
public class SmsServiceIOImpl implements SmsServiceIO{

    SerialPortDriverUsb _portDriver = null;
    private boolean messageEnvoyer = false;

    public SmsServiceIOImpl() {
    }

    public boolean isMessageEnvoyer() {
        return messageEnvoyer;
    }

    public void setMessageEnvoyer(boolean messageEnvoyer) {
        this.messageEnvoyer = messageEnvoyer;
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
    public void envoie(String s) throws Exception {
        
        _portDriver.writeToSerial(s);
        System.out.println("Envoit du message: " + s);
        _portDriver.closeCurrentPort();
        setMessageEnvoyer(true);
    }
}
