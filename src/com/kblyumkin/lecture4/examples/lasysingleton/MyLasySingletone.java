package com.kblyumkin.lecture4.examples.lasysingleton;

public class MyLasySingletone {
    private static MyLasySingletone thiz;

    private MyLasySingletone() {}

    public static MyLasySingletone getInstance() {
        if (thiz == null) {
            thiz = new MyLasySingletone();
        }
        return thiz;
    }
}
