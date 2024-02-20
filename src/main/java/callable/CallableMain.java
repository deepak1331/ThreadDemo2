package callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int n = 5;
        FutureTask[] futureTasks = new FutureTask[n];

        for (int i = 0; i < n; i++) {
            MyCallable myCallable = new MyCallable();
            futureTasks[i] = new FutureTask(myCallable);
            Thread thread = new Thread(futureTasks[i]);
            thread.start();
        }

        for(int i=0;i<n;i++)
            System.out.printf("Callable[%d] value is : %d%n", i, futureTasks[i].get());

    }
}
