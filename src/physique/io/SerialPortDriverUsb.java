/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import lml.tsiris.serialcomm.SerialComImpl;

/**
 *
 * @author saturne
 */
public class SerialPortDriverUsb {

    private boolean serialOpen;
    private CommPortIdentifier portId; //identifiant du port
    private SerialPort sPort; //le port serie
    private OutputStream os;
    private InputStream is;
    private BufferedReader br;
    private InputStreamReader isr;
    private final int tailleBloc = 8;

    public SerialPortDriverUsb() {
    }

    public void writeToSerial(String tel, String grillage) throws IOException {
        byte[] bytes = ("\2" + tel + grillage + "\3").getBytes();
        for (byte b : bytes) {
            try {
                os.write(b);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(SerialPortDriverUsb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String read() throws IOException {
        String data = null;
        byte[] buff = new byte[500];
        StringBuffer inputBuffer = new StringBuffer();
        int nb = 0;

        nb = is.read();
        for (int i = 0; i < nb; i++) {
            inputBuffer.append((char) buff[i]);
            data += (char) buff[i];
        }

        return data;
    }

    /**
     *
     * Permet la lecture ligne par ligne
     *
     * @return chaine de caratcére représentant ligne par ligne
     * @throws IOException
     */
    public String readLine() throws IOException {
        return this.br.readLine();
    }

    private void delay() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException ex) {
            Logger.getLogger(SerialComImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Methode de fermeture des flux et port.
     */
    public void close() {
        System.out.println("Close");
        try {
            if (is != null) {
                this.is.close();
            }
            if (os != null) {
                this.os.close();
            }

        } catch (IOException e) {
            System.err.println("error on close");
        }
        if (sPort != null) {
            sPort.close();
        }
    }

    /**
     * Permet l'ouverture de la communication physique
     *
     * @param port Chemin de la communication physique
     * @param speed Vitesse de lecture de la communication physique
     * @param dataBits Nombre de bits de donnée
     * @param stopBits Bits de stop
     * @param parity Parité de la communication
     * @return True(vrai) si la communication à bien été ouverte ou False(faux)
     * si elle à échouée
     */
    public boolean open(String port, int speed, int dataBits, int stopBits, int parity) throws Exception {
        this.serialOpen = false;

        // recuperation de l'identifiant du port
        sPort = (SerialPort) CommPortIdentifier.getPortIdentifier(port).open("serie", 9600);
        sPort.setSerialPortParams(speed, dataBits, stopBits, parity);
        //sPort.setRTS(false); // modif

        //recuperation du flux de lecture et ecriture du port
        this.os = getsPort().getOutputStream();
        this.is = getsPort().getInputStream();
        this.isr = new InputStreamReader(is);
        this.br = new BufferedReader(isr);
        // tout est ok !
        this.serialOpen = true;
        System.out.println("SerialCom.open " + getsPort().getName() + " OK !");

        return this.serialOpen;
    }

    /**
     * Permet de savoir si la communication est toujours ouverte
     *
     * @return Vrai(true) si la communication est ouverte False(faux) si ce
     * n'est plus le cas
     *
     */
    public boolean isOpen() {
        return this.serialOpen;
    }

    /**
     * @return the sPort
     */
    public SerialPort getsPort() {
        return sPort;
    }
}