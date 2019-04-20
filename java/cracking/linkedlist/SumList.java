package linkedlist;

import static linkedlist.LinkedListUtil.*;
import linkedlist.Node;
import java.util.*;

public class SumList {
  public static Node sumReverse(Node n1, Node n2) {
    Node head = null;
    Node current = null;
    int carry = 0;

    while(n1 != null || n2 != null) {
        int sum = (n1 == null ? 0 : n1.getData()) + (n2 == null ? 0 : n2.getData()) + carry;
        int value = sum % 10;
        carry = sum / 10;

        if(head == null) {
          current = new Node(value);
          head = current;
        } else {
          current = current.setNext(new Node(value));
        }

        n1 = (n1 == null ? null : n1.getNext());
        n2 = (n2 == null ? null : n2.getNext());
    }

    if(carry == 1) {
      current.setNext(new Node(1));
    }

    return head;
  }

  private static Stack<Node> fill(Node node) {
    Stack<Node> stack = new Stack<>();

    while(node != null) {
        stack.push(node);
        node = node.getNext();
    }

    return stack;
  }

  public static Node sum(Node n1, Node n2) {
    Node head = null;
    Stack<Node> s1 = fill(n1);
    Stack<Node> s2 = fill(n2);
    Stack<Node> sumStack = new Stack<>();

    int carry = 0;
    while(!s1.isEmpty() || !s2.isEmpty()) {
      n1 = s1.isEmpty() ? null : s1.pop();
      n2 = s2.isEmpty() ? null : s2.pop();

      int sum = (n1 == null ? 0 : n1.getData()) + (n2 == null ? 0 : n2.getData()) +  carry;
      int value = sum % 10;
      carry = sum / 10;

      sumStack.push(new Node(value));
    }
    if(carry == 1) {
      sumStack.push(new Node(carry));
    }

    Node current = null;
    while(!sumStack.isEmpty()) {
      if(head == null) {
        current = sumStack.pop();
        head = current;
      } else {
        current = current.setNext(sumStack.pop());
      }
    }

    return head;
  }

  public static void test1() {
    Node n1 = new Node(7);
    n1.setNext(new Node(1))
      .setNext(new Node(6));

    Node n2 = new Node(5);
    n2.setNext(new Node(9))
      .setNext(new Node(3))
      .setNext(new Node(1));

    print(sumReverse(n1, n2));
  }

  public static void test2() {
    Node n1 = new Node(1);
    n1.setNext(new Node(1))
      .setNext(new Node(1));

    Node n2 = new Node(2);
    n2.setNext(new Node(2))
      .setNext(new Node(2));

    print(sumReverse(n1, n2));
  }

  public static void test3() {
    print(sumReverse(null, null));
  }

  public static void test4() {
    Node n2 = new Node(2);
    n2.setNext(new Node(2))
      .setNext(new Node(2));

    print(sumReverse(null, n2));

  }

  public static void test5() {
    Node n1 = new Node(1);

    Node n2 = new Node(9);
    n2.setNext(new Node(9))
      .setNext(new Node(9));

    print(sumReverse(n1, n2));
  }

  public static void test6() {
    Node n1 = new Node(6);
    n1.setNext(new Node(1))
      .setNext(new Node(7));

    Node n2 = new Node(1);
    n2.setNext(new Node(3))
      .setNext(new Node(9))
      .setNext(new Node(5));

    print(sum(n1, n2));
  }

  public static void test7() {
    Node n1 = new Node(1);

    Node n2 = new Node(9);
    n2.setNext(new Node(9))
      .setNext(new Node(9));

    print(sum(n1, n2));
  }

  public static void main(String... s) {
    test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    test7();
  }
}
