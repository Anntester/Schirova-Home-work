package com.kblyumkin.lecture10.examples;

import static com.kblyumkin.lecture10.examples.WaitNotifyExamples.*;

public class WaitNotifyExamples {
    public static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SlaveRunnable());
        Thread anotherThread = new Thread(new SlaveRunnable());
        //Thread masterThread = new Thread(new MasterRunnable());
        thread.start();
        anotherThread.start();
        //masterThread.start();
        System.out.println("Exiting app");
    }

}

class SlaveRunnable implements Runnable {
    public void run() {
        synchronized (lock) {
            System.out.println("Entering the thread" + Thread.currentThread().getName());
            lock.notify();
            sleepAndIgnoreException();
            lock.notify();
            System.out.println("I'm done" + Thread.currentThread().getName());
        }
    }

    private void sleepAndIgnoreException() {
        try {
            lock.wait();
            /*Thread.sleep(time);*/
        } catch (InterruptedException e) {/*NOP*/}
    }
}

class MasterRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                lock.notifyAll();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {/*NOP*/}
        }
    }
}
