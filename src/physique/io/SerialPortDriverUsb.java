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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saturne
 */
public class SerialPortDriverUsb implements SerialPortEventListener{

    SmsServiceIOImpl smsServiceIOImpl = null;
    private static SerialPortDriverRadio _serialPortDriver;
    private SerialPort _port = null;
    private OutputStream _serialOutput = null;
    private String _portName = null;
    private InputStream _serialInput = null;
    final static int NEW_LINE_ASCII = 8;
    String logText = "";


    public SerialPortDriverUsb(SmsServiceIOImpl smsServiceIOImpl) {
        this.smsServiceIOImpl = smsServiceIOImpl;
        cycle();
    }

    private void closeCurrentPort() {
        if (_port != null) {
            try {
                _port.close();
            }
            catch (Exception e) {
                System.out.println("ERROR: Unable to close the serial port.");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        _port = null;
        _serialOutput = null;
        _portName = null;
    }

    private Enumeration<CommPortIdentifier> getSerialPorts() {
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

    private void cycle() {
        try {
            /* Close the old port.
             */
            String oldPortName = _portName;
            closeCurrentPort();

            /* Loop through the list of serial ports until getting to the one currently
             * in use.
             */
            Enumeration<CommPortIdentifier> ports = getSerialPorts();
            while (ports.hasMoreElements()) {
                CommPortIdentifier port = ports.nextElement();
                if (port.getName().equals(oldPortName)) {
                    break;
                }
            }

            /* If the previous loop got to the end of the list of available ports, set it back
             * at the beginning.
             */
            if (!ports.hasMoreElements()) {
                ports = getSerialPorts();
            }

            /* Take the next serial port in line and attempt to open it.
             */
            while (ports.hasMoreElements()) {
                CommPortIdentifier port = ports.nextElement();
                try {
                    _port = (SerialPort) port.open("Serial port", 9600);
                }
                catch (Exception e)
                {
                    System.out.println("ERROR: Unable to open port " + port.getName() + ". Trying the next one.");
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    closeCurrentPort();
                    continue;
                }

                _port.setSerialPortParams(9600, 8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                _portName = port.getName();
                _serialOutput = _port.getOutputStream();
                break;
            }

            if (_port == null) {
                System.out.println("ERROR: Unable to open any serial port.");
            }
        }
        catch (Exception e) {
            System.out.println("ERROR: Unable to recycle port.");
            System.out.println(e.getMessage());
            e.printStackTrace();
            closeCurrentPort();
        }
    }

    public String getPortName() {
        if (_portName != null) {
            return _portName;
        }
        else {
            return "NONE";
        }
    }

    public void cyclePort() {
        cycle();
    }

    public void writeToSerial(String numero) {
        int i = Integer.parseInt(numero);
        try {
            _serialOutput.write(i);
        } catch (IOException ex) {
            System.out.print("Impossible d'écrire");
        }
    }
    
    public boolean initIOStream() {
        boolean successful = false;

        try {
            _serialInput = _port.getInputStream();
            _serialOutput = _port.getOutputStream();

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
//            _port.setRTS(false); // a rajouter pour radio
            _port.addEventListener(this);
            _port.notifyOnDataAvailable(true);
        } catch (TooManyListenersException e) {
            logText = "Too many listeners. (" + e.toString() + ")";
            System.out.print(logText + "\n");
        }
    }
    
   @Override
    public void serialEvent(SerialPortEvent evt) {
        try {
            byte singleData = (byte) _serialInput.read();

            if (singleData != NEW_LINE_ASCII) {
                logText = new String(new byte[]{singleData});
                System.out.print(logText);
            } else {
                System.out.print("\n");
            }
        } catch (Exception e) {
            logText = "Failed to read data. (" + e.toString() + ")";
            System.out.print(logText + "\n");
        }
    }
   
   public String read() throws IOException {
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
}
