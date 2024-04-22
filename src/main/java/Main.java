import org.springframework.boot.autoconfigure.cache.CacheProperties;

import javax.xml.ws.soap.Addressing;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Main {

    private String name;
    private String age;

    public static void main(String[] args) throws InterruptedException {
//        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        queue.add(11);
        queue.add(12);
        queue.add(15);
        queue.add(1);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.remove(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}