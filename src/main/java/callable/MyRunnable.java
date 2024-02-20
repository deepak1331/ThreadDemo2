package callable;

import java.util.Random;

public class MyRunnable implements Runnable {


    // create a shared Object for storing result
    private Object result = null;

    @Override
    public void run() {

        //create an instance of Random class for generating random number
        Random obj = new Random();

        // generate random number using Random class
        Integer number = obj.nextInt(10);

        // use try-catch because Runnable doesn't throw any Exception
        try {
            Thread.sleep(number * 10);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        // store the returned value in result after completion
        result = number;

        // wake up threads blocked on the get() method
        synchronized (this) {
            notifyAll();
        }
    }

    // get() method for returning the result
    public synchronized Object get() throws InterruptedException {
        while (result == null) {
            wait();
        }
        return result;
    }
}

