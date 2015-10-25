package com.kblyumkin.lecture2.examples;

import java.util.Arrays;

public class ArrayInsertSorter {
    public static void main(String[] args) {
        int[] array = {2, 5, 1, 6, 4};

        for (int barrier = 1; barrier < array.length; barrier++) {
            int currElem = array[barrier];
            int prev = barrier - 1;
            while (prev > -1 && array[prev] > currElem) {
                array[prev + 1] = array[prev];
                array[prev] = currElem;
                prev--;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
