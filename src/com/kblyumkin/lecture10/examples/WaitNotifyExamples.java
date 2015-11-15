package com.kblyumkin.lecture10.examples;

public class WaitNotifyExamples {
    public static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SlaveRunnable());
        Thread anotherThread = new Thread(new SlaveRunnable());
        Thread masterThread = new Thread(new MasterRunnable());
        thread.start();
        anotherThread.start();
        masterThread.start();
        System.out.println("Exiting app");
    }

}

class SlaveRunnable implements Runnable {
    public void run() {
        synchronized (WaitNotifyExamples.lock) {
            System.out.println("Entering the thread" + Thread.currentThread().getName());
            sleepAndIgnoreException();
            System.out.println("I'm done" + Thread.currentThread().getName());
        }
    }

    private void sleepAndIgnoreException() {
        try {
            WaitNotifyExamples.lock.wait();
            /*Thread.sleep(time);*/
        } catch (InterruptedException e) {/*NOP*/}
    }
}

class MasterRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (WaitNotifyExamples.lock) {
                WaitNotifyExamples.lock.notifyAll();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {/*NOP*/}
        }
    }
}
