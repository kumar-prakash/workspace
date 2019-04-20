package linkedlist;

import linkedlist.Node;
import static linkedlist.LinkedListUtil.*;

public class Partition {

  static Node getNextLarge(Node node, int k) {
      while(node != null) {
        if(node.getData() >= k) {
          return node;
        }
        node = node.getNext();
      }
      return node;
  }

  static Node getNextSmall(Node node, int k) {
    while(node != null) {
      if(node.getData() < k) {
        return node;
      }
      node = node.getNext();
    }
    return node;
  }

  public static void partition(Node head, int k) {
    if(head == null) {
      return;
    }
    Node large = getNextLarge(head, k);
    Node small = getNextSmall(large, k);
    while(large != null && small != null) {
      // swap;
      
    }
  }
}
