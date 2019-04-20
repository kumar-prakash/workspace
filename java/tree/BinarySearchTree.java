import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

public class BinarySearchTree {
    int findMin(Node node) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = findMin(node.left);
        int rightMin = findMin(node.right);
        if(leftMin < rightMin) {
            if(leftMin < node.data) {
                return leftMin;
            } else {
                return node.data;
            }
        } else {
            if(rightMin < node.data) {
                return rightMin;
            } else {
                return node.data;
            }
        }
    }

    int findMax(Node node) {
        if(node == null) {
            return -1;
        }
        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);
        if(leftMax > rightMax) {
            if(node.data > leftMax) {
                return node.data;
            } else {
                return leftMax;
            }
        } else {
            if(node.data > rightMax) {
                return node.data;
            } else {
                return rightMax;
            }
        }
    }

    boolean isValid(Node root, HashSet<Integer> visited) {
        if(root == null) {
            return true;
        }
        if(visited.contains(root.data)) {
            return false;
        }
        visited.add(root.data);
        if(!(isValid(root.left, visited) && isValid(root.right, visited))) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return true;
        } else if(root.left == null) {
            return root.data < findMin(root.right);
        } else if(root.right == null) {
            return root.data > findMax(root.left);
        } else {
            return root.data > findMax(root.left) && root.data < findMin(root.right);
        }
    }

    boolean checkBST(Node root) {
        return isValid(root, new HashSet<Integer>());
    }

    public static void test1() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.left = new Node(5);
        root.right.right = new Node(7);

        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.checkBST(root));
    }

    public static void test2() {
        Node root = new Node(4);
        root.left = new Node(1);
        root.right = new Node(6);

        root.left.left = new Node(1);
        root.left.right = new Node(1);

        root.right.left = new Node(5);
        root.right.right = new Node(7);

        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.checkBST(root));
    }

    public static void test3() {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(7);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.checkBST(root)); 
    }

    public static void test4() {
        
    }

    public static void test5() {
        
    }

    public static void main(String... s) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }
}