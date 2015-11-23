package com.kblyumkin.lecture12additional.examples.proxy;

public class ProxyUseExample {
    public static void main(String[] args) {
        SomeMethodsClass example = new SomeMethodsClass();
        example.method1();
        example.method2("Test");
        System.out.println(example.method3(155));

        System.out.println("\n");

        SomeMethodsInterface sut = ProxyForSomeMethodClass.newInstance(example);
        sut.method1();
        System.out.println("\n");
        sut.method2("Test");
        System.out.println("\n");
        System.out.println(sut.method3(155));
    }
}
