# snesduino
Code used to interface between a SNES controller and an Arduino Uno, and the Arduino Uno and the PC.  Arduino gets SNES serial input, and a Java program translates that to keystrokes.

## SNES Controller Pins

The following is a representation of the SNES pad's pin configuration and their functionality.

```
  1 2 3 4   5 6 7
< o o o o | o o o >
    
1) +5V
2) Clock
3) Latch
4) Data
4) n/a
5) n/a
6) n/a
7) GND
```

Reference at [pinoutguide](https://pinoutguide.com/Game/snescontroller_pinout.shtml).

## Pin Configuration Function
    
```
pin_config(latch, clock, data);
```

## Serial output
    
This program prints a capital verison of the button to serial when the button is pressed (UP) and a lowercase version of the button when it is released (up).

## Quick start

This project makes use of [Arduino-Makefile](https://github.com/sudar/Arduino-Makefile) to flash the program onto the arduino.  To use this you'll need to install the `arduino-mk` package:

```
brew tap sudar/arduino-mk
brew install arduino-mk
```

You'll also need to install pyserial.  The makefile delegates resetting the board to a small python script:

```
pip install pyserial
```

You can then compile the arduino code, flash it onto the arduino, compile the java code, and run the java code with one make command:

```
make
```

Play games.

## Keymap

|    SNES      | Keyboard    |
|--------------|-------------|
| A            | A           |
| B            | B           |
| X            | X           |
| Y            | Y           |
| Left Bumper  | L           |
| Right Bumper | R           |
| Select       | S           |
| Start        | T           |
| Up           | Up Arrow    |
| Down         | Down Arrow  |
| Left         | Left Arrow  |
| Right        | Right Arrow |
