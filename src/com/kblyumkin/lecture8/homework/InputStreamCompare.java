package com.kblyumkin.lecture8.homework;

public class InputStreamCompare {
    public static void main(String[] args) {
        double j;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3000000; i++) {
            j = (Math.sin(i) + Math.cos(i)) / Math.tan(i);
        }
        System.out.println("It was taken " + (System.currentTimeMillis() - start) + " ms to do warm up");
    }
}
