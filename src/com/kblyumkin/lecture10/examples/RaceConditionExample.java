package com.kblyumkin.lecture10.examples;

public class RaceConditionExample {
    private static long value;
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new MyPositiveRunnable()).start();
        new Thread(new MyNegativeRunnable()).start();

    }

    private static class MyPositiveRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                long valueNow;
                synchronized (lock) {
                    value = 1000;
                    valueNow = value;
                }
                if (valueNow != 1000) {
                    System.out.println("Value = " + valueNow);
                }
            }
        }
    }

    private static class MyNegativeRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                long valueNow;
                synchronized (lock) {
                    value = -1000;
                    valueNow = value;
                }

                if (valueNow != -1000) {
                    System.out.println("Value = " + valueNow);
                }
            }
        }
    }
}
