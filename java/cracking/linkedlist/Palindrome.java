package linkedlist;

import java.util.*;
import linkedlist.Node;
import static linkedlist.LinkedListUtil.*;

public class Palindrome {
  public static boolean isPalindrome(Node node) {
    Stack<Node> stack = new Stack<>();

    Node slow = node;
    Node fast = node;
    while(slow != null) {
      if(fast != null) {
        stack.push(slow);
      } else {
        Node current = stack.pop();
        if(current.getData() != slow.getData()) {
          return false;
        }
      }
      if(fast != null && fast.getNext() == null) {
        stack.pop();
      }
      slow = slow.getNext();
      fast = (fast != null && fast.getNext() != null) ? fast.getNext().getNext() : null;
    }

    return true;
  }

  static void test1() {
      Node node = new Node(1);
      node.setNext(new Node(2))
      .setNext(new Node(3))
      .setNext(new Node(2))
      .setNext(new Node(1));

      System.out.println(isPalindrome(node));
  }

  static void test2() {
    Node node = new Node(1);
    node.setNext(new Node(2))
    .setNext(new Node(2))
    .setNext(new Node(1));

    System.out.println(isPalindrome(node));
  }

  static void test3() {
    Node node = new Node(1);
    node.setNext(new Node(2))
    .setNext(new Node(3))
    .setNext(new Node(4));

    System.out.println(isPalindrome(node));
  }

  public static void main(String... s) {
      test1();
      test2();
      test3();
  }
}
