package scheduleFuture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleWithDelayDemo implements Runnable {
    int i = 0;

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        //Future<?> submit = scheduledExecutorService.submit(new ScheduleWithDelayDemo());
        ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new ScheduleWithDelayDemo(), 2, TimeUnit.SECONDS);
        //scheduledExecutorService.scheduleWithFixedDelay(new ScheduleExecutor_scheduleAtFixedRateDemo(), 2, 1, TimeUnit.SECONDS);
       // schedule.sc
    }

    @Override
    public void run() {
        System.out.println("Called after 2 seconds delay");
    }
}
