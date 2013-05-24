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
    private String numeroGrillage = "";
    private String numeroGrillageOld = "";

    public DetecteurIntrusionServiceIOImpl() {
    }

    public String getNumeroGrillage() {
        return numeroGrillage;
    }

    public void setNumeroGrillage(String numeroGrillage) {
        this.numeroGrillage = numeroGrillage;
    }

    @Override
    public void creationPort() throws Exception {
        try {
            _portDriver = new SerialPortDriverRadio();
            _portDriver.open("/dev/ttyUSB0", 9600, 8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            System.out.println(_portDriver.getsPort());
            Thread t = new Thread(this);
            t.start();
        } catch (Exception e) {
            System.out.println("Carte detecteur grillage non connecté");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                numeroGrillage = _portDriver.readLine();
                if (!numeroGrillage.equals(this.numeroGrillageOld)) {
                    this.setChanged();
                    this.notifyObservers();
                }
                this.numeroGrillageOld = this.numeroGrillage;
                System.out.println("Information reçu " + getNumeroGrillage());
                //PhysiqueIOFactory.getSmsServiceIO().envoie(numeroGrillage);
            } catch (Exception ex) {
                Logger.getLogger(DetecteurIntrusionServiceIOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
