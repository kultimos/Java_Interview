import org.springframework.boot.autoconfigure.cache.CacheProperties;

import javax.xml.ws.soap.Addressing;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws Exception {
        BiT biT1 = new BiT();
        biT1.setNum(5);
        BiT biT2 = new BiT();
        BiT biT3 = new BiT();
        biT2.setNum(100);
        biT3.setNum(99);
        List<BiT> list = Arrays.asList(biT1, biT2, biT3);
        for(BiT u: list) {
            System.out.println(u.getNum());
        }
        Collections.sort(list, (o1, o2) -> (o1.getNum()+2 - o2.getNum()));
        for(BiT u: list) {
            System.out.println(u.getNum());
        }
    }
}

class BiT {
    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}