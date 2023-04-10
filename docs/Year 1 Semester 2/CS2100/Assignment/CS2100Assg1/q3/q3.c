#include <stdio.h>
#include <stdint.h>
#include <math.h>
#include "q3.h"

#define INTEG_LEN   10
#define FRACT_LEN   6

// Fill in your student ID, name and tutorial group here:

// STUDENT ID (A0255555X): 
// NAME: Moon Ji Hoon
// TUTORIAL GROUP (T03): 

void print_bits(int16_t v) {

    // Pre: y = a 16 bit integer to be printed in binary
    // Post: y is printed in binary

    uint16_t mask = 0b1000000000000000;
    for(int i = 0; i<16; i++) {
        if(v & mask) 
            printf("1");
        else
            printf("0");

        mask = mask >> 1;
    }
}

int16_t float_to_fixed(float x){
    return pow(2,6)*x;
}

float fixed_to_float(int16_t x) {
    return x/pow(2,6);
}

int16_t negate(int16_t x) {
    return pow(2,16)-x;
}

int16_t add(int16_t x, int16_t y) {
    return x+y;
}

int16_t subtract(int16_t x, int16_t y) {
    return x+negate(y);
}

