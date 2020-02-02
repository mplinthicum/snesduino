package com.mplinthicum.snesduino;

import java.awt.Robot;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 * Handles port creation and connection, and runs the listener.
 *
 * @author Michael Linthicum
 */
public class Snesduino {

    private Robot robot;
    private SerialPort serialPort;

    public Snesduino(final Robot robot) {
        this.robot = robot;
    }

    /**
     * Gets serial port list and constructs the object interface.
     */
    public void initialize() {
        String[] serialPortNames = SerialPortList.getPortNames();
        if(serialPortNames.length != 1) {
            throw new RuntimeException("Not exactly one available serial port...");
        }

        String serialPortName = serialPortNames[0];
        System.out.println("Serial port: " + serialPortName);
        serialPort = new SerialPort(serialPortName);
    }

    /**
     * Opens port runs the listener.
     */
    public void run() {
        try {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_14400,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            SnesSerialListener snesReader = new SnesSerialListener(serialPort, robot);
            serialPort.addEventListener(snesReader);
        } catch (SerialPortException spe) {
            throw new RuntimeException(spe.toString());
        }
    }
}
