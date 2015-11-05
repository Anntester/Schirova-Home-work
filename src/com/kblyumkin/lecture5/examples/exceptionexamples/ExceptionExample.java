package com.kblyumkin.lecture5.examples.exceptionexamples;

import java.sql.Connection;

public class ExceptionExample {
    public static void main(String[] args) throws Throwable{
        int choice = 0;
        System.err.println("Main started");

        try (ClosableExample c = new ClosableExample()) {
            if (choice == 0) {
                throw new Throwable("Message One");
            } else {
                throw new Error();
            }
        } catch (Throwable t) {
            throw new Throwable("Message 2", t);
        }
        //System.out.println("Main finished");
    }
}
