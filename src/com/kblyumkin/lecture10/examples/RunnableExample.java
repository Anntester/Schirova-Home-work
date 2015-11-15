package com.kblyumkin.lecture10.examples;

public class RunnableExample {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread thread = new Thread(new MyRunnable());
        Thread newThread = new Thread(new MyRunnable());
        thread.start();
        newThread.start();
        System.out.println("Exiting app");

    }
}

class MyRunnable implements Runnable{
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


