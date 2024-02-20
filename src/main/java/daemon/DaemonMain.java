package daemon;

/***
 * Daemon thread runs in the background usually for supporting the worked/main thread.
 * Once JVM completes executing the main thread, it will shutdown, and won't wait for the
 * Daemon thread to complete its execution, as it have the least priority
 */
public class DaemonMain extends Thread{

    public DaemonMain(int n) {
        this.n = n;
    }

    private int n;
    @Override
    public void run(){
        for(int i=0;i<=n;i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String args[]){
        DaemonMain d1 = new DaemonMain(20);

        DaemonMain d2 = new DaemonMain(40);
        d2.setDaemon(true);

        d1.start();
        d2.start();

    }
}
