package com.kblyumkin.lecture10.examples;

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread thread = new MyThread();
        Thread newThread = new MyThread();
        thread.start();
        newThread.start();
        System.out.println("Exiting app");

    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("Entering the thread" + Thread.currentThread().getName());
        sleepAndIgnoreException(1000);
        System.out.println("I'm done" + Thread.currentThread().getName());
    }

    private void sleepAndIgnoreException(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {/*NOP*/}
    }
}
