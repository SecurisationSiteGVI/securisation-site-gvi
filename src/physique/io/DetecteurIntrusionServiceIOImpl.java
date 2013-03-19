/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.Frame;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.TooManyListenersException;

/**
 *
 * @author Pierre
 */
public class DetecteurIntrusionServiceIOImpl implements DetecteurIntrusionServiceIO, SerialPortEventListener {

    Frame window = null;
    private static DetecteurIntrusionServiceIOImpl _serialPortDriver;
    private SerialPort _port = null;
    private OutputStream _serialOutput = null;
    private String _portName = null;
    private InputStream _serialInput = null;
    final static int NEW_LINE_ASCII = 8;
    String logText = "";

    public DetecteurIntrusionServiceIOImpl() {
    }

    @Override
    public void fermerPortActuel() throws Exception {
        if (_port != null) {
            try {
                _port.close();
            } catch (Exception e) {
                System.out.println("Erreur: impossible de fermer le port serie");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        _port = null;
        _serialOutput = null;
        _portName = null;
    }

    @Override
    public Enumeration<CommPortIdentifier> getPortSerie() throws Exception {
        List<CommPortIdentifier> list = new ArrayList<CommPortIdentifier>();
        Enumeration ports = CommPortIdentifier.getPortIdentifiers();
        while (ports.hasMoreElements()) {
            CommPortIdentifier port = (CommPortIdentifier) ports.nextElement();
            if (port.getPortType() == CommPortIdentifier.PORT_SERIAL && !port.isCurrentlyOwned()) {
                list.add(port);
            }
        }
        return Collections.enumeration(list);
    }

    @Override
    public void cycle() throws Exception {
        try {
            String oldPortName = _portName;
            fermerPortActuel();
            Enumeration<CommPortIdentifier> ports = getPortSerie();
            while (ports.hasMoreElements()) {
                CommPortIdentifier port = ports.nextElement();
                if (port.getName().equals(oldPortName)) {
                    break;
                }
            }
            if (!ports.hasMoreElements()) {
                ports = getPortSerie();
            }
            while (ports.hasMoreElements()) {
                CommPortIdentifier port = ports.nextElement();
                try {
                    _port = (SerialPort) port.open("Port Serie", 5000);
                } catch (Exception e) {
                    System.out.println("Erreur: impossible d'ouvrir le port " + port.getName() + ". essayez la prochaine fois");
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    fermerPortActuel();
                    continue;
                }
                _port.setSerialPortParams(9600, 8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                _portName = port.getName();
                _serialOutput = _port.getOutputStream();
                break;
            }
            if (_port == null) {
                System.out.println("Erreur: impossible d'ouvrir n'importe quel port série");
            }
        } catch (Exception e) {
            System.out.println("Erreur: incapable de recycler le port");
            System.out.println(e.getMessage());
            e.printStackTrace();
            fermerPortActuel();
        }

    }

    @Override
    public String getNomPort() throws Exception {
        if (_portName != null) {
            return _portName;
        } else {
            return "aucun";
        }
    }

    @Override
    public void cyclePort() throws Exception {
        cycle();
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
            cycle();
        }
    }

    @Override
    public boolean initIOStream() throws Exception {
        boolean successful = false;
        try {
            _serialInput = _port.getInputStream();
            _serialOutput = _port.getOutputStream();
            successful = true;
            return successful;
        } catch (IOException e) {
            logText = "I/O flux impossible a ouvrir. (" + e.toString() + ")";
            //window.jTextArea.setForeground(Color.red);
            //window.jTextArea.append(logText + "\n");
            return successful;
        }
    }

    @Override
    public void initListener() throws Exception {
        try {
            _port.setRTS(false); // a rajouter pour communication radio
            _port.addEventListener(this);
            _port.notifyOnDataAvailable(true);
        } catch (TooManyListenersException e) {
            logText = "trop grand nombre de listeners. (" + e.toString() + ")";
            //window.jTextArea.setForeground(color.red);
            //window.jTextArea.append(logText + "\n");
        }
    }

    @Override
    public String lire() throws Exception {
        String data = null;
        byte[] buff = new byte[500];
        StringBuffer inputBuffer = new StringBuffer();
        int nb = 0;
        nb = _serialInput.read();
        for(int i = 0; i < nb; i++) {
            inputBuffer.append((char) buff[i]);
            data += (char) buff[i];
        }
        return data;
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {
        try {
            byte singleData = (byte) _serialInput.read();
            if(singleData != NEW_LINE_ASCII) {
                logText = new String(new byte[]{singleData});
                //window.jTextArea.append(logText);
            } else {
                //window.jTextArea.append("\n");
            }
        } 
        catch (Exception e) {
            logText = "n'a pas pu lire les données. (" + e.toString() + ")";
            //window.jTextArea.setForeground(Color.red);
            //window.jTextArea.append(logText + "\n");
        }
    }
}
