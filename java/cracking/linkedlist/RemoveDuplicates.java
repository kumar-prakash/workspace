package linkedlist;

import java.util.*;
import linkedlist.Node;
import static linkedlist.LinkedListUtil.*;

public class RemoveDuplicates {

    static void removeDups(Node node) {
        if(node == null || node.getNext() == null) {
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        while(node != null && node.getNext() != null) {
            if(set.contains(node.getNext().getData())) {
                node.setNext(node.getNext().getNext());
            } else {
                set.add(node.getData());
            }
            node = node.getNext();
        }
    }

    public static void main(String... s) {
        Node head = new Node(1);
        head.setNext(new Node(2)).setNext(new Node(3)).setNext(new Node(4)).setNext(new Node(2));
        print(head);
        removeDups(head);
        print(head);

    }
}