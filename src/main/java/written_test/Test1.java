package written_test;

public class Test1 {

    public static final Object lock = new Object();
    public static Boolean flag = true; // true表示当前是奇数线程在持有锁  false表示当前是偶数线程在持有锁
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                for(int i=1;i<=100;i+=2) {
                    while(!flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(i);
                    flag = false;
                    lock.notify();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                for(int i=2;i<=100;i+=2) {
                    while(flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(i);
                    flag = true;
                    lock.notify();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
