package linkedlist;

import java.util.*;
import linkedlist.Node;
import static linkedlist.LinkedListUtil.*;

public class LoopDetection {

  public static Node detectLoop(Node node) {
    Node slow = node;
    Node fast = node.getNext() != null ? node.getNext().getNext() : null;

    while(slow != null && fast != null) {
      if(slow == fast) {
        return slow;
      }
      slow = slow.getNext();
      fast = fast.getNext() != null ? fast.getNext().getNext() : null;
    }
    return null;
  }

  static void test1() {
    Node three = new Node(3);
    Node n1 = new Node(1);
    n1.setNext(new Node(2))
    .setNext(three)
    .setNext(new Node(4))
    .setNext(new Node(5))
    .setNext(new Node(6))
    .setNext(new Node(7))
    .setNext(three);

    System.out.println(detectLoop(n1));
  }

  static void test2() {
    Node n1 = new Node(1);
    n1.setNext(new Node(2))
    .setNext(new Node(3))
    .setNext(new Node(4))
    .setNext(new Node(5))
    .setNext(new Node(6))
    .setNext(new Node(7));

    System.out.println(detectLoop(n1));
  }

  public static void main(String... s) {
    test1();
    test2();
  }
}
