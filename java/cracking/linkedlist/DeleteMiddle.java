package linkedlist;

import linkedlist.Node;
import static linkedlist.LinkedListUtil.*;

public class DeleteMiddle {
    public static void deleteMiddle(Node current) {
      if(current == null || current.getNext() == null) {
        return;
      }

      current.setData(current.getNext().getData());
      current.setNext(current.getNext().getNext());
    }

    public static void main(String... s) {
      Node four = new Node(4);
      Node six = new Node(6);
      Node head = new Node(1);
      head
          .setNext(new Node(2))
          .setNext(new Node(3))
          .setNext(four)
          .setNext(new Node(5))
          .setNext(six);

      print(head);
      //deleteMiddle(four);
      //deleteMiddle(six);
      deleteMiddle(null);
      print(head);
    }
}
