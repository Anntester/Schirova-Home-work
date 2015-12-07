package com.kblyumkin.lecture11.examples.interruptexamples;

public class IsInterruptedExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new IsInterruptedRunnable());

        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("Existing application");
    }
}

class IsInterruptedRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Starting thread execution " + Thread.currentThread().getName());
        long startTime = System.currentTimeMillis();
        while (!Thread.currentThread().isInterrupted()) {
            double d;
            for (long k = 1; k < 1_000_000; k++) {
                d = (Math.sin(k) + Math.cos(k)) / Math.tan(k);
                d++;
            }
            System.out.println(Thread.currentThread().isInterrupted());
        }
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println("Finishing thread execution " + Thread.currentThread().getName() + " . Elapsed " +
                (endTime - startTime) + " ms.");
    }
}

