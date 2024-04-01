package juc.four;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTaskExample implements Runnable {
    private String taskName;

    private AtomicInteger count;

    public ThreadPoolTaskExample(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskName + " is executing...");
        // Simulate some work being done
        try {
            Thread.sleep(5000); // Simulating work with sleep
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task " + taskName + " completed.");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create a thread pool with 2 threads
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        // Submit tasks to the thread pool
        Future<?> submit = executor.submit(new ThreadPoolTaskExample("Task 1"));
        System.out.println(submit.get());
        executor.submit(new ThreadPoolTaskExample("Task 2"));
        executor.submit(new ThreadPoolTaskExample("Task 3"));
        executor.submit(new ThreadPoolTaskExample("Task 4"));

        // Shutdown the thread pool after all tasks are completed
        executor.shutdown();

        // Wait until all tasks are completed
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks have completed.");
    }
}
