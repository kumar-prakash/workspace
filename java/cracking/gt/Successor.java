package gt;

public class Successor {
  static class Node {
    int data;
    Node left;
    Node right;
    Node parent;

    public Node(int data) {
      this.data = data;
    }

    public void setLeft(Node node) {
      this.left = node;
      node.parent = this;
    }

    public void setRight(Node node) {
        this.right = node;
        node.parent = this;
    }

    public String toString() {
      return String.valueOf(this.data);
    }
  }

  public Node findLeft(Node root) {
    if(root.left != null) {
      return findLeft(root.left);
    } else {
      return root;
    }
  }

  public Node findParent(Node root, Node current) {
      if(root == null) {
        return null;
      }
      if(root.data > current.data) {
        return root;
      }
      return findParent(root.parent, current);
  }

  public Node findSuccessor(Node root, Node current) {
      if(root == null) {
        return null;
      }
      if(root.data == current.data) {
        if(root.right != null) {
          return findLeft(root.right);
        } else {
          return findParent(root, current);
        }
      } else if(root.data > current.data) {
        return findSuccessor(root.left, current);
      } else {
        return findSuccessor(root.right, current);
      }
  }

  public static void main(String... s) {
    Node root = new Node(100);
    root.setLeft(new Node(50));
    root.setRight(new Node(150));

    root.left.setLeft(new Node(40));
    root.left.setRight(new Node(60));

    root.left.right.setLeft(new Node(55));
    root.left.right.setRight(new Node(65));

    root.right.setLeft(new Node(110));
    root.right.setRight(new Node(160));

    Successor suc = new Successor();
    System.out.println(suc.findSuccessor(root, new Node(50)));
    System.out.println(suc.findSuccessor(root, new Node(160)));
    System.out.println(suc.findSuccessor(root, new Node(100)));
    System.out.println(suc.findSuccessor(root, new Node(40)));
    
  }
}
