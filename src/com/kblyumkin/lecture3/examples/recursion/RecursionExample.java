package com.kblyumkin.lecture3.examples.recursion;

public class RecursionExample {
    public static void main(String[] args) {
        repeatingPrinter(5);
    }

    private static void repeatingPrinter(int count) {
        System.out.println("Hello " + count);
        if (count > 1) {
            repeatingPrinter(count - 1);
        }
        System.out.println("bye - bye " + count);
    }
}
