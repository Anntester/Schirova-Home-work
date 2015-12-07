package com.kblyumkin.lecture11.examples.deprecatedmethods;

public class SuspendResumeExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        Thread.sleep(500);
        thread.suspend();
        Thread.sleep(500);
        thread.resume();
        System.out.println("Existing application");
    }
}
