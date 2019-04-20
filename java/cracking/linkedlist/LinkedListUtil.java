package linkedlist;

import linkedlist.Node;

public class LinkedListUtil {
    public static void print(Node node) {
        if(node == null) {
            return;
        }
        while(node != null) {
            System.out.print(node + " ");
            node = node.getNext();
        }
        System.out.println("");
    }
}