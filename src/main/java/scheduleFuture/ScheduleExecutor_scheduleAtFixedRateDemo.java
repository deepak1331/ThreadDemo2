package scheduleFuture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutor_scheduleAtFixedRateDemo implements Runnable {
    int i = 0;

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new ScheduleExecutor_scheduleAtFixedRateDemo(), 1, 1, TimeUnit.SECONDS);
    }

    @Override
    public void run() {
        System.out.println(++i + " seconds has elapsed");
    }
}
