package juc;

public class SynchronizedInterruptExample {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 获取了锁");
                try {
                    Thread.sleep(5000); // 模拟持有锁一段时间
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " 被中断了");
                }
            }
            System.out.println(Thread.currentThread().getName() + " 释放了锁");
        });
        Thread t3= new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 获取了锁");
                try {
                    Thread.sleep(5000); // 模拟持有锁一段时间
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " 被中断了");
                }
            }
            System.out.println(Thread.currentThread().getName() + " 释放了锁");
        });

        Thread t2 = new Thread(() -> {
            t3.interrupt(); // 在 t1 获取锁前中断 t1 线程
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
