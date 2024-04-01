import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(12);
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.await();
        ConcurrentHashMap m = new ConcurrentHashMap();
    }
}