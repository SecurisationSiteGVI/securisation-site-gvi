/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pierre
 */
public class DetecteurIntrusionServiceIOImpl extends Observable implements DetecteurIntrusionServiceIO, Runnable {

    private static DetecteurIntrusionServiceIOImpl _serialPortDriver;
    private SerialPort _port = null;
    private OutputStream _serialOutput = null;
    private String _portName = null;
    private InputStream _serialInput = null;
    final static int NEW_LINE_ASCII = 8;
    String logText = "";

    public DetecteurIntrusionServiceIOImpl() {
        try {
        } catch (Exception ex) {
            //window.jTextArea.append(logText + "\n");
            System.out.println(logText + "\n");
        }
    }

    @Override
    public void EcrireSurPortSerie(byte key) throws Exception {
        try {
            if (_serialOutput != null) {
                _serialOutput.write(key);
                _serialOutput.flush();
            }
        } catch (Exception e) {
            System.out.println("Erreur: incapable d'écrire sur le port");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String lire() throws Exception {
        String data = null;
        byte[] buff = new byte[500];
        StringBuffer inputBuffer = new StringBuffer();
        int nb = 0;
        nb = _serialInput.read();
        for (int i = 0; i < nb; i++) {
            inputBuffer.append((char) buff[i]);
            data += (char) buff[i];
        }
        return data;
    }

    public void serialEvent(SerialPortEvent spe) {
        try {
            byte singleData = (byte) _serialInput.read();
            if (singleData != NEW_LINE_ASCII) {
                logText = new String(new byte[]{singleData});
                //window.jTextArea.append(logText);
                System.out.println(logText);
            } else {
                //window.jTextArea.append("\n");
                System.out.println("\n");
            }
        } catch (Exception e) {
            logText = "n'a pas pu lire les données. (" + e.toString() + ")";
            //window.jTextArea.setForeground(Color.red);
            System.out.println(logText + "\n");
            //window.jTextArea.append(logText + "\n");
        }
    }

    @Override
    public void run() {
        try {
            creationPort();
        } catch (Exception ex) {
            Logger.getLogger(DetecteurIntrusionServiceIOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void creationPort() throws Exception {
        _serialPortDriver = null;
        _serialPortDriver = new DetecteurIntrusionServiceIOImpl();

    }

}
