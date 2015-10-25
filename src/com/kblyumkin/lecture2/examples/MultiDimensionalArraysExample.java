package com.kblyumkin.lecture2.examples;

import java.util.Arrays;

public class MultiDimensionalArraysExample {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4},
                {3, 4, 5, 6},
                {7, 5, 4, 1}
        };
        int result = 0;
        for (int index = 0; index < array.length; index++) {
            for (int inner = 0; inner < array[index].length; inner++) {
                result += array[index][inner];
            }
        }

        System.out.println("Sum is equals to " + result);
    }
}
