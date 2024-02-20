package runnable;


public class RunnableDemo implements Runnable {
    public RunnableDemo() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " Status: NEW >" + Thread.currentThread().getState());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableDemo(), "RunnableThread-01");
        Thread t2 = new Thread(new RunnableDemo(), "RunnableThread-02");

        t2.start();
        t1.start();
    }

    public void run() {
        Long startTime = System.currentTimeMillis();
        System.out.println("Thread: " + Thread.currentThread().getName() + " Status: " + Thread.currentThread().getState());

        for (int i = 1; i <= 50; ++i) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " Value: " + i);

           /* try {
                Thread.sleep(500);
            } catch (InterruptedException var4) {
            }*/
        }

        System.out.println("Thread: " + Thread.currentThread().getName() + " Status: DEAD  Time Taken : " + (System.currentTimeMillis() - startTime) + " ms\n");
    }
}