package shutdownhook;

public class SDHDemo extends Thread{

    @Override
    public void run(){

        System.out.println("ShutDownHook Demo");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new SDHDemo();
        System.out.println("Thread declared : " + currentThread().getName() + "Status: "+ currentThread().getState());
        Runtime.getRuntime().addShutdownHook(t1);
        t1.start();
        System.out.println("Going in 3 secs wait: ");
        Thread.sleep(3000);
        for(int i=0;i<100;i++)
            System.out.print(i);
        System.out.println("Wait completed, JVM Closing now.");


    }
}
