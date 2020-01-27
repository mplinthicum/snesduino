package com.mplinthicum.snesduino;

import java.awt.*;

public class Runner {
    public static void main(String[] args) throws Exception {
        SerialInput serialInput = new SerialInput(new Robot());
        serialInput.initialize();
        serialInput.run();
        System.out.println("Press your buttons...");
    }
}
