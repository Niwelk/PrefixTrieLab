package Trie;

public class LinkedList {

    public class Node {
        public String data;
        public Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null ? true : false;
    }

    public void addValue(String value) {
        Node currentNode = new Node(value);

        if (head == null) {
            head = currentNode;
            tail = currentNode;
        } else {
            tail.next = currentNode;
            tail = currentNode;
        }

        size++;
    }
}
