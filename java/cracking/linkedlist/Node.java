package linkedlist;

public class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public Node setNext(Node node) {
        return this.next = node;    
    }

    public String toString() {
        return String.valueOf(this.data);
    }
}