package join;

public class JoinMain extends Thread {

    public static void main(String[] args) throws InterruptedException {

        JoinMain j1 = new JoinMain();
        JoinMain j2 = new JoinMain();
        JoinMain j3 = new JoinMain();
        JoinMain j4 = new JoinMain();

        j1.start();
        j1.join(5000);
        j2.start();
        j3.start();
        j3.join();
        j4.start();
    }


    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
