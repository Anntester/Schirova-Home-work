package com.kblyumkin.lecture11.examples.deprecatedmethods;

public class DestroyExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        Thread.sleep(1000);
        thread.destroy();
        System.out.println("Existing application");
    }
}

