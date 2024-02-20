package threadpoolexecuters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TPE_Main {


    public static void main(String[] args) {
        //ThreadPoolExecutor threadPoolExecuters = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecuters = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        System.out.println("Largest executions: " + threadPoolExecuters.getLargestPoolSize());
        System.out.println("Maximum allowed threads: " + threadPoolExecuters.getMaximumPoolSize());
        System.out.println("Current threads in pool: " + threadPoolExecuters.getPoolSize());
        System.out.println("Currently executing threads: " + threadPoolExecuters.getActiveCount());
        System.out.println("Total number of threads(ever scheduled): " + threadPoolExecuters.getTaskCount());

        threadPoolExecuters.submit(new Task());
        threadPoolExecuters.submit(new Task());
        threadPoolExecuters.submit(new Task());
        threadPoolExecuters.submit(new Task());
        threadPoolExecuters.submit(new Task());

        System.out.println("\nCore threads: " + threadPoolExecuters.getCorePoolSize());
        System.out.println("Largest executions: " + threadPoolExecuters.getLargestPoolSize());
        System.out.println("Maximum allowed threads: " + threadPoolExecuters.getMaximumPoolSize());
        System.out.println("Current threads in pool: " + threadPoolExecuters.getPoolSize());
        System.out.println("Currently executing threads: " + threadPoolExecuters.getActiveCount());
        System.out.println("Total number of threads(ever scheduled): " + threadPoolExecuters.getTaskCount());
        threadPoolExecuters.shutdown();

   }
}
