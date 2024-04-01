package juc.four;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolCallableExample implements Callable<String> {
    private String taskName;

    public ThreadPoolCallableExample(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String call() {
        System.out.println("Task " + taskName + " is executing...");
        // Simulate some work being done
        try {
            Thread.sleep(5000); // Simulating work with sleep
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskName + " completed.");
        return taskName;
    }

    public static void main(String[] args) {
        int numOfTasks = 5;

        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // List to hold Future objects
        List<Future<String>> futures = new ArrayList<>();

        // Submit tasks to the thread pool
        for (int i = 1; i <= numOfTasks; i++) {
            Callable<String> task = new ThreadPoolCallableExample("Task " + i);
            Future<String> future = executor.submit(task);
            futures.add(future);
        }
        System.out.println("第一次看" + executor.isTerminated());
        // Count completed tasks
        int completedTasks = 0;
        for (Future<String> future : futures) {
            try {
                // Retrieve the result of the task
                future.get();
                completedTasks++;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("第二次看" + executor.isTerminated());

        // Shutdown the thread pool after all tasks are completed
        executor.shutdown();
        System.out.println("Total completed tasks: " + completedTasks);

        System.out.println("第三次看" + executor.isTerminated());
    }
}
