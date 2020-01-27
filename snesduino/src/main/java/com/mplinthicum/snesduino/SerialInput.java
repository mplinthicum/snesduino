package com.mplinthicum.snesduino;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class SerialInput {

    private SerialPort serialPort;
    private Robot robot;

    private void initialize() throws AWTException {

        String[] portNames = SerialPortList.getPortNames();
        robot = new Robot();

        if (portNames.length == 0) {
            System.err.println("No available serial ports");
            return;
        }

        serialPort = new SerialPort(portNames[0]);
    }

    private void run() {
        try {
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            SerialPortReader serialPortReader = new SerialPortReader();
            serialPort.addEventListener(serialPortReader);
        } catch (SerialPortException spe) {
            System.out.println(spe.toString());
        }
    }

    private class SerialPortReader implements SerialPortEventListener {

        @Override
        public void serialEvent(SerialPortEvent event) {
            if(event.isRXCHAR()){
                try {
                    String input = serialPort.readString(1);
                    buttonCaptureToKeyPress(input);
                }
                catch (SerialPortException ex) {
                    System.out.println(ex.toString());
                }
            }
        }
    }

    private void buttonCaptureToKeyPress(String snesInput) {
        switch(snesInput) {
            case "A":
                robot.keyPress(KeyEvent.VK_A);
                break;
            case "a":
                robot.keyRelease(KeyEvent.VK_A);
                break;
            case "B":
                robot.keyPress(KeyEvent.VK_B);
                break;
            case "b":
                robot.keyRelease(KeyEvent.VK_B);
                break;
            case "X":
                robot.keyPress(KeyEvent.VK_X);
                break;
            case "x":
                robot.keyRelease(KeyEvent.VK_X);
                break;
            case "Y":
                robot.keyPress(KeyEvent.VK_Y);
                break;
            case "y":
                robot.keyRelease(KeyEvent.VK_Y);
                break;
            case "U":
                robot.keyPress(KeyEvent.VK_UP);
                break;
            case "u":
                robot.keyRelease(KeyEvent.VK_UP);
                break;
            case "D":
                robot.keyPress(KeyEvent.VK_DOWN);
                break;
            case "d":
                robot.keyRelease(KeyEvent.VK_DOWN);
                break;
            case "F":
                robot.keyPress(KeyEvent.VK_LEFT);
                break;
            case "f":
                robot.keyRelease(KeyEvent.VK_LEFT);
                break;
            case "H":
                robot.keyPress(KeyEvent.VK_RIGHT);
                break;
            case "h":
                robot.keyRelease(KeyEvent.VK_RIGHT);
                break;
            case "R":
                robot.keyPress(KeyEvent.VK_R);
                break;
            case "r":
                robot.keyRelease(KeyEvent.VK_R);
                break;
            case "L":
                robot.keyPress(KeyEvent.VK_L);
                break;
            case "l":
                robot.keyRelease(KeyEvent.VK_L);
                break;
            case "T":
                robot.keyPress(KeyEvent.VK_S);
                break;
            case "t":
                robot.keyRelease(KeyEvent.VK_S);
                break;
            case "S":
                robot.keyPress(KeyEvent.VK_D);
                break;
            case "s":
                robot.keyRelease(KeyEvent.VK_D);
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        SerialInput serialInput = new SerialInput();
        serialInput.initialize();
        serialInput.run();
        System.out.println("Press your buttons...");
    }
}