package gt;

import java.util.*;

public class CheckBalanced {
  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }

    public String toString() {
      return String.valueOf(this.data);
    }
  }

  public int checkHeight(Node root) {
    if(root == null) {
      return -1;
    }

    int left = checkHeight(root.left);
    if(left == Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    int right = checkHeight(root.right);
    if(right == Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    if(Math.abs(left - right) > 1) {
      return Integer.MIN_VALUE;
    }

    return Math.max(left, right) + 1;
  }

  public boolean isBalanced(Node root) {
      return checkHeight(root) != Integer.MIN_VALUE;
  }

  public static void main(String... s) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.right.left = new Node(11);
    //root.left.right.left.left = new Node(12);

    root.right.left = new Node(6);
    root.right.right = new Node(7);

    root.right.left.left = new Node(8);
    root.right.left.right = new Node(10);

    CheckBalanced obj = new CheckBalanced();
    System.out.println(obj.isBalanced(root));

  }
}
