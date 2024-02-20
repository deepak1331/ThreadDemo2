package scheduleFuture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MyMain {
    public static void main(String[] args) {

        final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        new Timer().start();
        //Submits a one-shot task that becomes enabled after the given delay.
        final ScheduledFuture<?> beepHandler = scheduledExecutorService.schedule(new BeepTask(), 5, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                beepHandler.cancel(true);
                System.out.println("scheduledExecutorService Called: " + beepHandler.isCancelled());
                scheduledExecutorService.shutdown();
            }
        }, 2L, TimeUnit.SECONDS);
    }

    static class BeepTask implements Runnable {
        @Override
        public void run() {
            System.out.println("BeepTask");
        }
    }

    static class Timer extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 8; i++) {
                System.out.println(i + " seconds passed");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
