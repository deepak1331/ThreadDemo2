package org.example;

public class App {
    public static void main(String[] args) {

        MyThread t1 = new MyThread("Thread-01");
        MyThread t2 = new MyThread("Thread-02");

        MyRunnableThread r1 = new MyRunnableThread(5);
        Thread t3 = new Thread(r1);
        t3.setName("Runnable Thread");

        Thread t4 = new Thread(new MyRunnableThread(9), "Runnable Thread 02");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
