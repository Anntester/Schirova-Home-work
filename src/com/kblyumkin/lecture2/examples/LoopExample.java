package com.kblyumkin.lecture2.examples;

public class LoopExample {
    public static void main(String[] args) {
        int result = 0;
        /*for (int index =1; index <= 100; index++) {
            result +=index;
        }*/
        int index = 0;
        /*while(index <= -100) {
            result += index++;
        }*/
        do {
            result += ++index;
        } while (index <= -100);
        System.out.println(result);
    }
}
