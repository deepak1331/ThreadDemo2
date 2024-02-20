package threadpoolexecuters;


public class Task implements Runnable {
    public Task() {
    }

    public void run() {
        Long period = (long)(Math.random() * 10.0);
        System.out.println("Running Task | Thread Name: " + Thread.currentThread().getName());

        try {
            Thread.sleep(period);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }

        System.out.println("Completed Task | Thread Name: " + Thread.currentThread().getName());
    }
}
