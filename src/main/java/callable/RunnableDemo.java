package callable;

public class RunnableDemo {
    public static void main(String args[]) throws InterruptedException {

        //create an array of MyRunnable
        MyRunnable[] tasks = new MyRunnable[5];

        //use for loop
        for (int i = 0; i < 5; i++) {
            //create an instance of RunnableInterface
            tasks[i] = new MyRunnable();

            // create a Thread with RunnableInterface
            Thread thread = new Thread(tasks[i]);

            thread.start();
        }

        //use for loop for printing returned value of each Runnable
        for (int j = 0; j < tasks.length; j++) {
            // use get() method to print the returned value
            System.out.println("Runnable[" + j + "] ===> " + tasks[j].get());
        }
    }
}
