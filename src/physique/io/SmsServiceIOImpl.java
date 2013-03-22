/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physique.io;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.Color;
import java.awt.Frame;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pierre
 */
public class SmsServiceIOImpl implements SmsServiceIO, SerialPortEventListener{
    Frame window = null;
    private Enumeration ports = null;
    private HashMap portMap = new HashMap();
    private CommPortIdentifier selectedPortIdentifier = null;
    private SerialPort serialPort = null;
    private InputStream input = null;
    private OutputStream output = null;
    private boolean bConnected = false;
    final static int TIMEOUT = 2000;
    final static int SPACE_ASCII = 32;
    final static int DASH_ASCII = 45;
    final static int NEW_LINE_ASCII = 10;
    String logText = "";
    
    public SmsServiceIOImpl() {
        this.window = window;
    }

    @Override
    public void rechercheDePort() {
        System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");
        ports = CommPortIdentifier.getPortIdentifiers();
        while(ports.hasMoreElements()) {
            CommPortIdentifier curPort = (CommPortIdentifier) ports.nextElement();
            if(curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                //window.jComboBox.addItem(curPort.getName());
                portMap.put(curPort.getName(), curPort);
            }
        }
    }

    @Override
    public void envoyerGrillage(String grillage) {
        try {
            int i = Integer.parseInt(grillage);
            output.write(i);
        } catch (IOException ex) {
            Logger.getLogger(SmsServiceIOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void connexion() {
        //String selectedPort = (String) window.jComboBox.getSelectedItem();
        //selectedPortIdentifier = (CommPortIdentifier) portMap.get(selectedPort);
        CommPort commPort = null;
        try {
            commPort = selectedPortIdentifier.open("TigerControlPanel", TIMEOUT);
            serialPort = (SerialPort) commPort;
            setConnexion(true);
            //logText = selectedPort + " ouverture reussi.";
            //window.jTextArea.setForeground(Color.black);
            //window.jTextArea.append(logText + "\n");
            System.out.println("Ouverture réussi");
        } catch(PortInUseException e) {
            //logText = selectedPort + "est en cours d'utilisation. (" + e.toString() + ")";
            //window.jTextArea.setForeground(Color.black);
            //window.jTextArea.append(logText + "\n");
            System.out.println("Port en cours d'utilisation");
        } catch(Exception e) {
            //logText = "echec de l'ouverture " + selectedPort + "(" + e.toString() + ")";
            //window.jTextArea.append(logText + "\n");
            //window.jTextArea.setForeground(Color.red);
            System.out.println("Echec de l'ouverture du port");
        }
    }

    @Override
    public void setConnexion(boolean bConnected) {
        this.bConnected = bConnected;
    }

    @Override
    public boolean getConnexion() {
        return bConnected;
    }

    @Override
    public boolean initIOStream() {
        boolean successful = false;
        try {
            input = serialPort.getInputStream();
            output = serialPort.getOutputStream();
            successful = true;
            return successful;
        } catch (IOException e) {
            logText = "I/O echec de l'ouverture du flux. (" + e.toString() + ")";
            //window.jTextArea.setForeground(Color.red);
            //window.jTextArea.append(logText + "\n");
            System.out.println("I/O echec de l'ouverture du flux");
            return successful;
        }
    }

    @Override
    public void initListener() {
        try {
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);           
        } catch(TooManyListenersException e) {
            logText = "Trop grands nombres de listeners. (" + e.toString() + ")";
            //window.jTextArea.setForeground(Color.red);
            //window.jTextArea.append(logText + "\n");
            System.out.println("Trop grands nombres de listeners");
        }
    }

    @Override
    public void disconnect() {
        try {
            serialPort.removeEventListener();
            serialPort.close();
            input.close();
            output.close();
            setConnexion(false);
            logText = "Deconnecter.";
            //window.jTextArea.setForeground(Color.red);
            //window.jTextArea.append(logText + "\n");
            System.out.print("Deconnecter");
        } catch (Exception e) {
            logText = "echec de la fermeture du port " + serialPort.getName() + "(" + e.toString() + ")";
            //window.jTextArea.setForeground(Color.red);
            //window.jTextArea.append(logText  "\n");*
            System.out.println("Echec de l'ouverture du port");
        }
    }

    @Override
    public void serialEvent(SerialPortEvent evt) {
        try {
            byte singleData = (byte) input.read();
            if(singleData != NEW_LINE_ASCII) {
                logText = new String(new byte[]{singleData});
                //window.jTextArea.append(logText);
            } else {
                //window.jTextArea.append("\n");
            }
        } catch (Exception e) {
            logText = "n'à pas pu lire les données. (" + e.toString() + ")";
            //window.jTextArea.setForeground(Color.red);
            //window.jTextArea.append(logText + "\n");
            System.out.println("N'à pas pu lire les données");
        }
    }
}
