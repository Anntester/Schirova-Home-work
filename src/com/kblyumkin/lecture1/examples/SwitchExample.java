package com.kblyumkin.lecture1.examples;

public class SwitchExample {
    public static void main(String[] args) {


        int a = 2;
        switch (a) {
            case 1 :
                System.out.println(a);
                /*break;*/
            case 2 :
                System.out.println(a++);
                /*break;*/
            case 3:
                System.out.println(++a);
                /*break;*/

        }
        System.out.println(a);
    }
}
