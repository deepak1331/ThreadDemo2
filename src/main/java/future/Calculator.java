package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Calculator {

    private ExecutorService executor = Executors.newFixedThreadPool(2);
    /***
     * Creates a thread pool that creates new threads as needed, but will reuse previously constructed
     * threads when they are available. These pools will typically improve the performance of programs
     * that execute many short-lived asynchronous tasks. Calls to execute will reuse previously constructed
     * threads if available. If no existing thread is available, a new thread will be created and added
     * to the pool. Threads that have not been used for sixty seconds are terminated and removed from
     * the cache. Thus, a pool that remains idle for long enough will not consume any resources.
     * Note that pools with similar properties but different details (for example, timeout parameters)
     * may be created using
     */
    //private ExecutorService executor = Executors.newCachedThreadPool(); //this could be a better choice
    //Other task will be started only after first is completed
    //private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculateSquare(Integer n) {
        return executor.submit(() -> {
            Thread.sleep(1000);
            return n * n;
        });
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Calculator calculator = new Calculator();
        Future<Integer> future1 = calculator.calculateSquare(9);

        Future<Integer> future2 = calculator.calculateSquare(13);

        while (!(future2.isDone() && future1.isDone())) {
            System.out.printf("future1 is Completed: %s  and future2 is Completed: %s%n", future1.isDone(), future2.isDone());
            Thread.sleep(300);
        }

        System.out.printf("future1 Result: %d  and future2 Result: %d%n", future1.get(), future2.get());
    }
}