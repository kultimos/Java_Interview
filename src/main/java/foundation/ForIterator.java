package foundation;

import java.util.*;

public class ForIterator {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4.简述kafka的Partition写入策略.md");
        list.add("5");
        Iterator iterator1 = list.descendingIterator();
        while(iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        ListIterator iterator2 = list.listIterator();
        while (true) {
            if(iterator2.hasPrevious() && iterator2.hasNext()) {
                System.out.println(iterator2.next());
            } else if(iterator2.hasNext()) {
                iterator2.next();
            } else {
                break;
            }
        }
    }
}
