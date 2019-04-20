package linkedlist;

import java.util.*;
import linkedlist.Node;
import static linkedlist.LinkedListUtil.*;

public class Intersection {

  static int length(Node node) {
      int length = 0;
      while(node != null) {
        length++;
        node = node.getNext();
      }
      return length;
  }

  public static Node findIntersection(Node n1, Node n2) {
    int l1 = length(n1);
    int l2 = length(n2);

    if(l1 < l2) {
      Node temp = n2;
      n2 = n1;
      n1 = temp;
    }
    // assuming n1 is always large or equals

    int diff = Math.abs(l1 - l2);
    while(diff > 0) {
        n1 = n1.getNext();
        diff--;
    }

    while(n1 != null) {
        if(n1 == n2) {
          return n1;
        }
        n1 = n1.getNext();
        n2 = n2.getNext();
    }

    return null;
  }

  static void test1() {
    Node four = new Node(4);

    Node n1 = new Node(1);
    n1.setNext(new Node(2))
    .setNext(new Node(3))
    .setNext(four)
    .setNext(new Node(5));

    Node n2 = new Node(10);
    n2.setNext(four);

    System.out.println(findIntersection(n1, n2));
  }

  static void test2() {
    Node four = new Node(4);

    Node n1 = new Node(1);
    n1.setNext(new Node(2))
    .setNext(new Node(3))
    .setNext(four)
    .setNext(new Node(5));

    Node n2 = new Node(10);
    n2.setNext(new Node(5));

    System.out.println(findIntersection(n1, n2));
  }

  public static void main(String... s) {
    test1();
    test2();
  }
}
