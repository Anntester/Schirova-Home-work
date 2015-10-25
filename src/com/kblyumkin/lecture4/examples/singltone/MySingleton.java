package com.kblyumkin.lecture4.examples.singltone;

public class MySingleton {
    private static MySingleton thiz = new MySingleton();

    private MySingleton() {}

    public static MySingleton getInstance() {
        return thiz;
    }
}
