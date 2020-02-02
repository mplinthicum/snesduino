package com.mplinthicum.snesduino;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * A listener to handle snes serial output to a serial port and
 * translate it to a keystroke.
 *
 * @author Michael Linthicum
 */
public class SnesSerialListener implements SerialPortEventListener {

    private SerialPort serialPort;
    private Robot robot;

    /**
     *
     * @param serialPort
     * @param robot
     */
    public SnesSerialListener(final SerialPort serialPort, Robot robot) {
        this.serialPort = serialPort;
        this.robot = robot;
    }

    /**
     * Reads one byte of information from the serial port as a string
     * and translates it to a keystroke.
     *
     * @param event
     */
    @Override
    public void serialEvent(SerialPortEvent event) {
        if(event.isRXCHAR()){
            try {
                String input = serialPort.readString(1);
                buttonCaptureToKeyPress(input);
            }
            catch (SerialPortException ex) {
                throw new RuntimeException(ex.toString());
            }
        }
    }

    /**
     * Translates a serial output to a key press.
     *
     * @param snesInput {@link String} read from the serial port
     */
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
                robot.keyPress(KeyEvent.VK_T);
                break;
            case "t":
                robot.keyRelease(KeyEvent.VK_T);
                break;
            case "S":
                robot.keyPress(KeyEvent.VK_S);
                break;
            case "s":
                robot.keyRelease(KeyEvent.VK_S);
                break;
        }
    }
}
