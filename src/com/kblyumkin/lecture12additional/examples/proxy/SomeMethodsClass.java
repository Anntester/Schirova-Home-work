package com.kblyumkin.lecture12additional.examples.proxy;

public class SomeMethodsClass implements SomeMethodsInterface {

    public void method1() {
        System.out.println("Method 1 call");
    }

    public void method2(String arg) {
        System.out.println("Method 2 call with arg = " +
                arg);
    }

    public String method3(int arg) {
        System.out.println("Method 3 call with arg = " + arg);
        return "New result of SomeClass";
    }


}
