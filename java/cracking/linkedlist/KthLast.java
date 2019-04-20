package linkedlist;
import linkedlist.Node;
import static linkedlist.LinkedListUtil.*;

public class KthLast {
    static int kthFromLast(Node head, int k) {
        if(k == 0 || head == null) {
            return -1;
        }

        int counter = 0;
        Node kth = null;
        Node current = head;
        while(current != null) {
            counter++;
            if(counter >= k) {
                if(kth == null) {
                    kth = head;
                } else {
                    kth = kth.getNext();
                }
            }
            current = current.getNext();
        }

        return kth == null ? -1 : kth.getData();
    }

    public static void main(String... s) {
        Node head = new Node(1);
        head
            .setNext(new Node(2))
            .setNext(new Node(3))
            .setNext(new Node(4))
            .setNext(new Node(5))
            .setNext(new Node(6));

        System.out.println(kthFromLast(head, 3));
        System.out.println(kthFromLast(head, 8));
        System.out.println(kthFromLast(head, 6));
        System.out.println(kthFromLast(head, 1));
        System.out.println(kthFromLast(head, 0));
    }
}
