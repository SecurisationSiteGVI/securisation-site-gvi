/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import gnu.io.SerialPort;
import java.util.logging.Level;
import java.util.logging.Logger;
import lml.tsiris.serialcomm.SerialCom;
import lml.tsiris.serialcomm.SerialComImpl;

/**
 *
 * @author Pierre
 */
public class SmsServiceIOImpl implements SmsServiceIO {

    SerialPortDriverUsb _portDriver = null;
    private boolean messageEnvoyer = false;
    private SerialCom is;

    public SmsServiceIOImpl() {
    }

    @Override
    public void creationPort() throws Exception {
        try {
            _portDriver = new SerialPortDriverUsb();
//            this.is = new SerialComImpl();
            _portDriver.open("/dev/ttyACM0", 9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            Thread.sleep(2000);
//            this.is = new SerialComImpl();
//            this.is.open("/dev/ttyACM0", 9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
        } catch (Exception e) {
            System.out.println("Carte d'envoie sms non connecté");
        }
    }

    @Override
    public void envoie(String s) throws Exception {

//        _portDriver.writeToSerial(s);
//        this.is.write(s);
        creationPort();
        _portDriver.writeToSerial(s);
        System.out.println("Envoit du message: " + s);
        _portDriver.close();
//        this.is.close();
    }
}
