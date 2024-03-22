package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ToHashMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("giannis","34");
        map.put("jordan","23");
        map.put("james","23");
        map.put("curry","30");
        method(map);
        System.out.println("----------------");
        /**
         * 还可以使用jdk1.8的foreach对map进行快速遍历
         */
        map.forEach((k,v) -> {
            System.out.println(k + " - " + v);
        });
    }

    /**
     * 迭代器方式遍历hashMap
     * @param map
     */
    public static void method(HashMap<String, String> map) {
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + " - " + next.getValue());
        }
    }
}
