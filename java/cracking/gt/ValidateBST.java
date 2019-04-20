package gt;

import java.util.*;

public class ValidateBST {
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

  public boolean isValid(Node root, int min, int max) {
      if(root == null) {
        return true;
      }
      if(root.data <= min || root.data >= max) {
        return false;
      }
      return isValid(root.left, min, root.data) && isValid(root.right, root.data, max);
  }

  public boolean isValidBST(Node root) {
    return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static void main(String... s) {
    Node root = new Node(100);
    root.left = new Node(50);
    root.right = new Node(150);

    root.left.left = new Node(40);
    root.left.right = new Node(60);

    root.left.right.left = new Node(55);
    root.left.right.right = new Node(65);

    root.right.left = new Node(110);
    root.right.right = new Node(160);

    ValidateBST validate = new ValidateBST();
    System.out.println(validate.isValidBST(root));
  }
}
