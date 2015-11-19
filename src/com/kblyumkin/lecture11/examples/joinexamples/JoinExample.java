package com.kblyumkin.lecture11.examples.joinexamples;

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        thread.join();
        System.out.println("Finishing main method");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Starting thread execution " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {/*NOP*/}
        System.out.println("Finishing thread execution " + Thread.currentThread().getName());
    }
}