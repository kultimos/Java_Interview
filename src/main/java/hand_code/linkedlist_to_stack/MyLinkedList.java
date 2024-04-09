package hand_code;

import java.util.LinkedList;

public class MyLinkedList extends LinkedList {

    public void push(Object o) {
        this.add(o);
    }

    public Object pop() {
        return removeLast();
    }
}
