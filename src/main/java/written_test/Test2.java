package written_test;

public class Test2 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printNodeInfo(node1);
        Node node = reverseNode(node1);
        System.out.println("=======");
        printNodeInfo(node);
    }

    public static void printNodeInfo(Node head) {
        while(head != null) {
            System.out.println(head.getValue());
            head = head.next;
        }
    }

    public static Node reverseNode(Node head) {
        Node curr = head;
        Node prev = null;
        while(curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
