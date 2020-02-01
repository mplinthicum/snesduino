# mvn vars
MVN_VERSION := $(shell mvn -f ./snesduino -q -Dexec.executable="echo" -Dexec.args='$${project.version}' --non-recursive exec:exec)
JAR_NAME := snesduino-$(MVN_VERSION).jar

# arduino vars
MONITOR_PORT := /dev/tty.usbmodem*
BOARD_TAG := uno
include /usr/local/opt/arduino-mk/Arduino.mk

all: upload compile_java run_java

compile_java:
	mvn -f ./snesduino clean install

run_java:
	java -jar ./snesduino/target/$(JAR_NAME)
