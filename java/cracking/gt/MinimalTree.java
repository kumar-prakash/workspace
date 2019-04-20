package gt;

import java.util.*;

public class MinimalTree {
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

  public Node createTree(int [] arr, int start, int end) {
    if(arr == null || arr.length == 0 || end < start) {
      return null;
    }

    int mid = (start + end) / 2;
    Node root = new Node(arr[mid]);
    root.left = createTree(arr, start, mid - 1);
    root.right = createTree(arr, mid + 1, end);
    return root;
  }

  public static void traverse(Node root) {
      if(root == null) {
        return;
      }

      Queue<Node> queue = new LinkedList<>();
      queue.add(root);

      while(!queue.isEmpty()) {
        int size = queue.size();
        while(size--> 0) {
          Node current = queue.poll();
          if(current.left != null) {
              queue.add(current.left);
          }
          if(current.right != null) {
            queue.add(current.right);
          }
          System.out.print(current + " ");
        }
        System.out.println("");
      }
  }

  public static void main(String... s) {
    MinimalTree tree = new MinimalTree();
    int [] data = new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Node root = tree.createTree(data, 0, data.length - 1);
    traverse(root);
  }
}
