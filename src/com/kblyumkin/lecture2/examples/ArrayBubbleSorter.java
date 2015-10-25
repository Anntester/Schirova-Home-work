package com.kblyumkin.lecture2.examples;

import java.util.Arrays;

public class ArrayBubbleSorter {
    public static void main(String[] args) {
        int[] array = {2, 5, 1, 6, 4};
        for (int index = 0; index < array.length; index++) {
            for (int curIndex = index + 1; curIndex < array.length; curIndex++) {
                if (array[index] > array[curIndex]) {
                    int currElem = array[index];
                    array[index]= array[curIndex];
                    array[curIndex] = currElem;
                 }
            }
        }



        System.out.println(Arrays.toString(array));

    }
}
