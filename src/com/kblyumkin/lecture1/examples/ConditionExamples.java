package com.kblyumkin.lecture1.examples;

public class ConditionExamples {
    public static void main(String[] args) {
        int first = -10;

        if (first >= 0) {
            System.out.println("first is positive");
        } else {
            System.out.println("first is negative");
        }

        String result = first >= 0 ? "positive" : "negative";
        System.out.println("first is " + result);



    }
}
