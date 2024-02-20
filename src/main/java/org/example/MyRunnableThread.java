package org.example;

public class MyRunnableThread implements Runnable {

    private int n;

    public MyRunnableThread(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("%10s : %3d X %d = %d %n", Thread.currentThread().getName(), n, i, n * i);
        }
    }
}
