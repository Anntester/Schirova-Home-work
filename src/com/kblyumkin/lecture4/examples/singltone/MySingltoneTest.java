package com.kblyumkin.lecture4.examples.singltone;

public class MySingltoneTest {
    public static void main(String[] args) {
        MySingleton first = MySingleton.getInstance();
        MySingleton second = MySingleton.getInstance();
        System.out.println(first.equals(second));
    }
}
