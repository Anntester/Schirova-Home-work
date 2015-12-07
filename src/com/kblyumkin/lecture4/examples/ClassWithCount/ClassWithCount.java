package com.kblyumkin.lecture4.examples.classwithcount;

public class ClassWithCount {
    static int counter = 0;

    ClassWithCount() {
        counter++;
    }

    public static int getCount() {
        return counter;
    }
}
