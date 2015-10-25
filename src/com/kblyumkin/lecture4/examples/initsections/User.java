package com.kblyumkin.lecture4.examples.initsections;

public class User {

    private static int count;

    static {
        count = 0;
        System.out.println("Static init");
    }

    {
        System.out.println("Before Constructor");

    }
    public User() {
        System.out.println("User's constructor");
    }
}
