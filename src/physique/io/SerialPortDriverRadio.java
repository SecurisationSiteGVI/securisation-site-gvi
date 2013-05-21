package physique.io;

/**
 *
 * @author Pierre
 */
import gnu.io.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import lml.tsiris.serialcomm.SerialComImpl;

public class SerialPortDriverRadio extends Observable {

    private boolean serialOpen;
    private CommPortIdentifier portId; //identifiant du port
    private SerialPort sPort; //le port serie
    private OutputStream os;
    private InputStream is;
    private BufferedReader br;
    private InputStreamReader isr;
    private final int tailleBloc = 8;

    public SerialPortDriverRadio() {
    }

    public void writeToSerial(String s) {
        int i = Integer.parseInt(s);
        try {
            os.write(i);
        } catch (IOException ex) {
            System.out.print("Impossible d'écrire");
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


        sPort = (SerialPort) CommPortIdentifier.getPortIdentifier(port).open("radio", 5000); // recuperation de l'identifiant du port
        sPort.setSerialPortParams(speed, dataBits, stopBits, parity);
        sPort.setRTS(false); // modif


        this.os = getsPort().getOutputStream(); //recuperation du flux de lecture et ecriture du port
        this.is = getsPort().getInputStream();
        this.isr = new InputStreamReader(is);
        this.br = new BufferedReader(isr);  // tout est ok !

        this.serialOpen = true;
        System.out.println("SerialCom.open " + getsPort().getName() + " OK !");

        return this.serialOpen;
    }

    public boolean isOpen() {   //Permet de savoir si la communication est toujours ouverte
        return this.serialOpen; //Return True si la communication est ouverte False si ce n'est plus le cas
    }

    public SerialPort getsPort() {
        return sPort;
    }
}