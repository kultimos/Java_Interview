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
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("1",2);
    }
}
