package callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int randomNum = new Random().nextInt(100);
        //Thread.sleep(1000);
        return randomNum;
    }
}
