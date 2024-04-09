package hand_code;

public class Test {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.push("1");
        linkedList.push("2");
        linkedList.push("3");
        linkedList.push("4");
        linkedList.push("5");
        System.out.println(linkedList.pop());
        System.out.println(linkedList.size());
    }
}
