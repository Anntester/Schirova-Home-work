package com.kblyumkin.lecture5.examples.exceptionexamples;

public class ClosableExample implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("I'm closing");
    }
}
