package threadgroup;


public class ThreadGroupDemo implements Runnable {
    public ThreadGroupDemo() {
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroupDemo threadGroupDemo = new ThreadGroupDemo();
        threadGroupDemo.func();
    }

    public void run() {
        for (int i = 1; i < 6; ++i) {
            try {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
                Thread.sleep(100L);
            } catch (InterruptedException interruptedException) {
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished executing.");
    }

    public void func() throws InterruptedException {
        ThreadGroup parentTG = new ThreadGroup("Parent Thread Group");
        ThreadGroup childTG = new ThreadGroup("Child Thread Group");
        Thread pt1 = new Thread(parentTG, this);
        Thread pt2 = new Thread(parentTG, this);
        System.out.println("Active threads in \"" + parentTG.getName() + "\" = " + parentTG.activeCount());
        System.out.println("Starting Parent Thread Group Threads..");
        pt1.start();
        pt2.start();
        System.out.println("Active threads in \"" + parentTG.getName() + "\" = " + parentTG.activeCount());
        pt1.join();
        Thread t2 = new Thread(childTG, this);
        Thread t1 = new Thread(childTG, this);
        System.out.println("Active threads in \"" + childTG.getName() + "\" = " + childTG.activeCount());
        System.out.println("Starting Child Thread Group Threads.....");
        t2.start();
        t1.start();
        System.out.println("Active threads in \"" + childTG.getName() + "\" = " + childTG.activeCount());
    }
}