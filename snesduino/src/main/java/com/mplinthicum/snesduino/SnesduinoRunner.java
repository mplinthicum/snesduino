package com.mplinthicum.snesduino;

import java.awt.AWTException;
import java.awt.Robot;

/**
 * Access point main class.
 *
 * @author Michael Linthicum
 */
public class SnesduinoRunner {
    public static void main(String[] args) throws AWTException {
        Snesduino snesduino = new Snesduino(new Robot());
        snesduino.initialize();
        snesduino.run();
        System.out.println("Press your buttons...");
    }
}
