package com.mplinthicum.snesduino;

import java.awt.Robot;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class SerialInput {

    private Robot robot;
    private SerialPort serialPort;

    public SerialInput(final Robot robot) {
        this.robot = robot;
    }

    public void initialize() {
        String[] serialPortNames = SerialPortList.getPortNames();
        if(serialPortNames.length != 1) {
            throw new RuntimeException("Not exactly one available serial port...");
        }

        String serialPortName = serialPortNames[0];
        System.out.println("Serial port: " + serialPortName);
        serialPort = new SerialPort(serialPortName);
    }

    public void run() {
        try {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            SerialPortReader serialPortReader = new SerialPortReader(serialPort, robot);
            serialPort.addEventListener(serialPortReader);
        } catch (SerialPortException spe) {
           throw new RuntimeException(spe.toString());
        }
    }
}