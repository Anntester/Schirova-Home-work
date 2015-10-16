package com.kblyumkin.lecture1.homeWork;

public class SwitchValues {
    public static void main(String[] args) {
        int first = 5;
        int second = 10;

        first = first + second;//15
        second = first - second; //5
        first = first - second; //10

        System.out.println("First = " + first + " , second = " + second);
    }
}
