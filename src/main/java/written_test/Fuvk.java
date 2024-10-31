package written_test;

import java.util.concurrent.locks.Lock;

public class Fuvk {
    public static final Object object = new Object();
    public static boolean flag = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (object) {
                for (int i = 1; i <= 100; i += 2) {
                    while(flag) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    flag = true;
                    System.out.println(i);
                    object.notify();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (object) {
                for (int i = 2; i <= 100; i += 2) {
                    while(!flag) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    flag = false;
                    System.out.println(i);
                    object.notify();
                }
            }
        });
        thread2.start();
        thread1.start();
    }
}
