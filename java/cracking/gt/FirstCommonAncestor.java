package gt;

import java.util.*;

public class FirstCommonAncestor {
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

  public Node findFirstCommonAncestor(Node root, int first, int second) {
    if(root == null) {
      return null;
    }
    if(root.data == first || root.data == second) {
      return root;
    }
    Node left = findFirstCommonAncestor(root.left, first, second);
    Node right = findFirstCommonAncestor(root.right, first, second);
    if(left == null && right == null) {
      return null;
    } else if(left == null) {
      return right;
    } else if(right == null){
      return left;
    } else {
      return root;
    }
  }

  public static void main(String... s) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.left = new Node(6);
    root.right.right = new Node(7);

    root.left.left.left = new Node(14);
    root.left.left.right = new Node(15);

    root.left.right.left = new Node(12);
    root.left.right.right = new Node(13);

    FirstCommonAncestor first = new FirstCommonAncestor();
    System.out.println(first.findFirstCommonAncestor(root, 14, 12));
  }
}
