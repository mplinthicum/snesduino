#include <snespad.h>

SNESPad pad(4, 2, 6);

boolean pressed_b = false;
boolean pressed_y = false;
boolean pressed_select = false;
boolean pressed_start = false;
boolean pressed_up = false;
boolean pressed_down = false;
boolean pressed_left = false;
boolean pressed_right = false;
boolean pressed_a = false;
boolean pressed_x = false;
boolean pressed_l = false;
boolean pressed_r = false;

void setup(){
    Serial.begin(14400);
}

void loop(){
    unsigned int state = pad.get_state();

    if(!pressed_x && state & BTN_X){
        pressed_x = true;
        Serial.print("X");
    }
    if(pressed_x && !(state & BTN_X)){
        pressed_x = false;
        Serial.print("x");
    }

    if(!pressed_y && state & BTN_Y){
        pressed_y = true;
        Serial.print("Y");
    }
    if(pressed_y && !(state & BTN_Y)){
        pressed_y = false;
        Serial.print("y");
    }

    if(!pressed_a && state & BTN_A){
        pressed_a = true;
        Serial.print("A");
    }
    if(pressed_a && !(state & BTN_A)){
        pressed_a = false;
        Serial.print("a");
    }

    if(!pressed_b && state & BTN_B){
        pressed_b = true;
        Serial.print("B");
    }
    if(pressed_b && !(state & BTN_B)){
        pressed_b = false;
        Serial.print("b");
    }

    if(!pressed_r && state & BTN_R){
        pressed_r = true;
        Serial.print("R");
    }
    if(pressed_r && !(state & BTN_R)){
        pressed_r = false;
        Serial.print("r");
    }

    if(!pressed_l && state & BTN_L){
        pressed_l = true;
        Serial.print("L");
    }
    if(pressed_l && !(state & BTN_L)){
        pressed_l = false;
        Serial.print("l");
    }

    if(!pressed_select && state & BTN_SELECT){
        pressed_select = true;
        Serial.print("S");
    }
    if(pressed_select && !(state & BTN_SELECT)){
        pressed_select = false;
        Serial.print("s");
    }

    if(!pressed_start && state & BTN_START) {
        pressed_start = true;
        Serial.print("T");
    }
    if(pressed_start && !(state & BTN_START)){
        pressed_start = false;
        Serial.print("t");
    }

    if(!pressed_up && state & BTN_UP){
        pressed_up = true;
        Serial.print("U");
    }
    if(pressed_up && !(state & BTN_UP)){
        pressed_up = false;
        Serial.print("u");
    }

    if(!pressed_down && state & BTN_DOWN){
        pressed_down = true;
        Serial.print("D");
    }
    if(pressed_down && !(state & BTN_DOWN)){
        pressed_down = false;
        Serial.print("d");
    }

    if(!pressed_left && state & BTN_LEFT){
        pressed_left = true;
        Serial.print("F");
    }
    if(pressed_left && !(state & BTN_LEFT)){
        pressed_left = false;
        Serial.print("f");
    }

    if(!pressed_right && state & BTN_RIGHT){
        pressed_right = true;
        Serial.print("H");
    }
    if(pressed_right && !(state & BTN_RIGHT)){
        pressed_right = false;
        Serial.print("h");
    }
}
