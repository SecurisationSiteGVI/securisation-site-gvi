/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import gnu.io.SerialPort;

/**
 *
 * @author Pierre
 */
public class SmsServiceIOImpl implements SmsServiceIO {

    SerialPortDriverUsb _portDriver = new SerialPortDriverUsb();

    public SmsServiceIOImpl() {
    }

    @Override
    public void creationPort() throws Exception {
        try {
            _portDriver.open("/dev/ttyACM0", 9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

        } catch (Exception e) {
            System.out.println("Carte d'envoie sms non connecté");
        }
    }

    @Override
    public void envoieNumero(String numero) throws Exception {
        _portDriver.write(numero);
        System.out.println("Envoit du message au numéro " + numero);
        while (true) {
            _portDriver.read();
        }

    }
}
