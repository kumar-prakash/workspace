package gt;

import java.util.*;

public class ListOfDepths {
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

  public void levels(Node root, List<LinkedList<Integer>> list, int depth) {
    if(root == null) {
      return;
    }
    if(depth >= list.size()) {
      list.add(new LinkedList<Integer>());
    }
    list.get(depth).add(root.data);
    levels(root.left, list, depth + 1);
    levels(root.right, list, depth + 1);
  }

  public List<LinkedList<Integer>> listOfDepths(Node root) {
    List<LinkedList<Integer>> list = new ArrayList<>();
    levels(root, list, 0);
    return list;
  }

  public static void main(String... s) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);

    root.right.left = new Node(6);
    root.right.right = new Node(7);

    root.right.left.left = new Node(8);
    root.right.left.right = new Node(10);

    ListOfDepths depths = new ListOfDepths();
    System.out.println(depths.listOfDepths(root));
  }
}
