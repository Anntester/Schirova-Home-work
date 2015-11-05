package com.kblyumkin.lecture5.examples.monkeybuisness;

public class MonkeyWakeUpException extends Exception {

    public MonkeyWakeUpException(Double reason) {
        System.out.println("Reason is " + reason + ". Bad luck");
    }
}
