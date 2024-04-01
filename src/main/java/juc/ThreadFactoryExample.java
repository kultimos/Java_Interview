package juc;

import java.util.concurrent.*;

public class ThreadFactoryExample {
    public static void main(String[] args) {
        // 创建一个线程池，并指定线程工厂
        ExecutorService executor = Executors.newFixedThreadPool(5, new CustomThreadFactory());

        // 提交一些任务给线程池执行
        for (int i = 0; i < 10; i++) {
            executor.submit(new MyTask(i));
            executor.execute(new MyTask(i));
        }

        // 关闭线程池
        executor.shutdown();
    }

    // 自定义任务类
    static class MyTask implements Runnable {
        private final int taskId;

        MyTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            try {
                // 模拟任务执行
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task " + taskId + " is running on thread: " + Thread.currentThread().getName());
        }
    }

    // 自定义线程工厂类
    static class CustomThreadFactory implements ThreadFactory {
        private int count = 0;

        @Override
        public Thread newThread(Runnable r) {
            // 创建新线程并设置名称
            Thread thread = new Thread(r, "CustomThread-" + count++);
            // 设置线程为守护线程
            thread.setDaemon(false);
            // 设置线程优先级
            thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        }
    }
}
