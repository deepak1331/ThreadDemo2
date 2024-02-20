package org.example;

public class MyThread extends Thread{

    private String name;

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("%10s : %2d %n",Thread.currentThread().getName() , i);
        }
    }
}
