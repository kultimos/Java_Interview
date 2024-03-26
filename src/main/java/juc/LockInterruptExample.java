package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptExample {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                lock.lock(); // 可中断地获取锁
                System.out.println(Thread.currentThread().getName() + " 获取了锁");
                Thread.sleep(5000); // 模拟持有锁一段时间
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 被中断了");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " 释放了锁");
            }
        },"t1");
        Thread t3 = new Thread(() -> {
            try {
                lock.lockInterruptibly(); // 可中断地获取锁
                System.out.println(Thread.currentThread().getName() + " 获取了锁");
                Thread.sleep(5000); // 模拟持有锁一段时间
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 被中断了");
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " 释放了锁");
            }
        },"t3");

        Thread t2 = new Thread(() -> {
            t3.interrupt(); // 在 t1 获取锁前中断 t1 线程
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
