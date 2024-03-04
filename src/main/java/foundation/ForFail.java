package foundation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ForFail {
    public static void main(String[] args) {
//        safeFailed();
        quickFailed();
    }

    public static void quickFailed() {
        List<String> myList = new ArrayList<String>(3);
        myList.add("java");
        myList.add("python");
        myList.add("c++");
        Iterator<String> iterator = myList.iterator();
        while(iterator.hasNext()) {
            String language = iterator.next();
            System.out.println(language);

            //模拟在迭代过程中修改集合结构
            if(language.equals("java")) {
                myList.remove("python");
            }
        }
        System.out.println("最终的结果集合:" + myList);
    }

    public static void safeFailed() {
        Map<String, String> myMap = new ConcurrentHashMap<String, String>(3);
        myMap.put("a", "apple");
        myMap.put("b", "banana");
        myMap.put("c", "cherry");
        Iterator<Map.Entry<String, String>> iterator = myMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());

            //模拟在迭代过程中修改集合结构
            if (entry.getKey().equals("a")) {
                myMap.remove("b");
            }
        }
        System.out.println("最终的结果集合:" + myMap);
    }

}

