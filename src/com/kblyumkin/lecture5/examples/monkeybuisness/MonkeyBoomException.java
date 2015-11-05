package com.kblyumkin.lecture5.examples.monkeybuisness;

public class MonkeyBoomException extends RuntimeException {
    public MonkeyBoomException(double reason) {
        System.out.println("Reason is " + reason + ". Bad luck, boom-boom and bye-bye!");
    }
}
