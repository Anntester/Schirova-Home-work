package com.kblyumkin.lecture2.examples;

import java.util.Arrays;

public class SimpleArrayExample {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        /*array[0] = 1;
        array[1] = 2;
        array[2] = 3;*/
        int result = 0;

        for (int index = 0; index < array.length; index ++) {
            result += array[index];
        }

        System.out.println("Sum of elements of array " +
                Arrays.toString(array) + " = " + result);

    }
}
