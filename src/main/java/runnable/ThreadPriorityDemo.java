package runnable;

public class ThreadPriorityDemo extends Thread {
    ThreadPriorityDemo(String name, int priority) {
        super(name);
        this.setPriority(priority);
    }

    public void run() {
        System.out.println("\nThread: " + Thread.currentThread().getName() + ", Priority: " + Thread.currentThread().getPriority());

        for (int i = 1; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - Value : " + i);
            try {
                Thread.sleep(50L);
            } catch (InterruptedException interruptedException) {
            }
        }
        System.out.println("\nThread: " + Thread.currentThread().getName() + " exiting...");
    }

    public static void main(String[] args) {
        ThreadPriorityDemo t1 = new ThreadPriorityDemo("T1", Thread.MAX_PRIORITY);
        ThreadPriorityDemo t2 = new ThreadPriorityDemo("T2", Thread.MIN_PRIORITY);
        ThreadPriorityDemo t3 = new ThreadPriorityDemo("T3", Thread.NORM_PRIORITY);

        t2.start();
        t3.start();
        t1.start();
    }
}
