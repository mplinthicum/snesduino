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

There are two programs included in this repository that must be run simultaneously to achieve functionality.  The first is the program that is flashed onto the ardunio.  At this point in development to flash the program onto the arduino you must open csnesduino/csnesduino.ino in the arduino IDE and flash through the UI.

Once that is running you must run the java code.  Run the following command to compile the code into an uber jar:

```
cd sensduino
mvn clean install
```

Then run the code from the command line:

```
java -jar target/snesduino-1.0-SNAPSHOT.jar
```

Play games.
