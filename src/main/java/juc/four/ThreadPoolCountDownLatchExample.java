package juc.four;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolCountDownLatchExample {
    // 创建一个静态的 CountDownLatch 变量
    private static final CountDownLatch latch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 提交任务给线程池
        for (int i = 0; i < 5; i++) {
            executor.submit(new Worker(i));
        }
        // 等待所有任务完成
        latch.await();
        System.out.println("All tasks are completed.");

        // 关闭线程池
        executor.shutdown();
    }

    static class Worker implements Runnable {
        private final int taskId;

        public Worker(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            try {
                // 模拟任务执行
                System.out.println("Task " + taskId + " begin.");
                Thread.sleep(10000);
                System.out.println("Task " + taskId + " completed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 任务完成，调用countDown()方法
                latch.countDown();
            }
        }
    }
}