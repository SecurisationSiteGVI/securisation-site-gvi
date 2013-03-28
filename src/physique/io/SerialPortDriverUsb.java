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
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TooManyListenersException;

/**
 *
 * @author saturne
 */
public class SerialPortDriverUsb implements SerialPortEventListener {

    SmsServiceIOImpl smsServiceIOImpl = null;
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

    public SerialPortDriverUsb(SmsServiceIOImpl smsServiceIOImpl) {
        this.smsServiceIOImpl = smsServiceIOImpl;
    }

    public void searchForPorts() {
        System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");
        ports = CommPortIdentifier.getPortIdentifiers();

        while (ports.hasMoreElements()) {
            CommPortIdentifier curPort = (CommPortIdentifier) ports.nextElement();

            if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL) {
//                window.jComboBox.addItem(curPort.getName());
                portMap.put(curPort.getName(), curPort);
            }
        }
    }

    @Override
    public void serialEvent(SerialPortEvent evt) {
        try {
            byte singleData = (byte) input.read();

            if (singleData != NEW_LINE_ASCII) {
                logText = new String(new byte[]{singleData});
                System.out.println(logText + "\n");
            } else {
                System.out.println("\n");
            }
        } catch (Exception e) {
            logText = "Failed to read data. (" + e.toString() + ")";
            System.out.println(logText + "\n");
        }
    }

    public void envoyerGrillage(String grillage) throws IOException {

        int i = Integer.parseInt(grillage);
        output.write(i);
    }

    public void connect() {
//        String selectedPort = (String) window.jComboBox.getSelectedItem();
//        selectedPortIdentifier = (CommPortIdentifier) portMap.get(selectedPort);

        CommPort commPort = null;

        try {
            commPort = selectedPortIdentifier.open("TigerControlPanel", TIMEOUT);
            serialPort = (SerialPort) commPort;

            setConnected(true);

//            logText = selectedPort + " opened successfully.";
            System.out.println(logText + "\n");

        } catch (PortInUseException e) {
//            logText = selectedPort + " is in use. (" + e.toString() + ")";

            System.out.println(logText + "\n");
        } catch (Exception e) {
//            logText = "Failed to open " + selectedPort + "(" + e.toString() + ")";
            System.out.println(logText + "\n");
        }
    }

    public void setConnected(boolean bConnected) {
        this.bConnected = bConnected;
    }

    final public boolean getConnected() {
        return bConnected;
    }

    public boolean initIOStream() {
        boolean successful = false;

        try {
            input = serialPort.getInputStream();
            output = serialPort.getOutputStream();

            successful = true;
            return successful;
        } catch (IOException e) {
            logText = "I/O Streams failed to open. (" + e.toString() + ")";
            System.out.println(logText + "\n");
            return successful;
        }
    }

    public void initListener() {
        try {
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (TooManyListenersException e) {
            logText = "Too many listeners. (" + e.toString() + ")";
            System.out.println(logText + "\n");
        }
    }

    public void disconnect() {
        try {
            serialPort.removeEventListener();
            serialPort.close();
            input.close();
            output.close();
            setConnected(false);

            logText = "Disconnected.";
            System.out.println(logText + "\n");
        } catch (Exception e) {
            logText = "Failed to close " + serialPort.getName() + "(" + e.toString() + ")";
            System.out.println(logText + "\n");
        }
    }
}
