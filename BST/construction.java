package BST;

import java.util.*;

public class construction {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node construct(int arr[], int low, int hi) {
        if (low > hi) {
            return null;
        }
        int mid = (low + hi) / 2;
        int data = arr[mid];
        Node lc = construct(arr, low, mid - 1);
        Node rc = construct(arr, mid + 1, hi);

        Node node = new Node(data, lc, rc);
        return node;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left != null ? node.left.data : ".";
        str += " <- " + node.data + " -> ";
        str += node.right != null ? node.right.data : ".";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static boolean find(Node root, int val) {// in bst search travels only along the path in which target exist
        if (root == null) {
            return false;
        }

        if (root.data == val) {
            return true;
        } else if (root.data > val) {
            return find(root.left, val);
        } else {
            return find(root.right, val);
        }
    }

    public static int max(Node root) {
        if (root.right != null) {
            return max(root.right);
        } else {
            return root.data;
        }
    }

    public static int min(Node root) {
        if (root.left != null) {
            return min(root.left);
        } else {
            return root.data;
        }
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls + rs + root.data;
    }

    public static void main(String args[]) {
        int arr[] = { 12, 25, 37, 50, 62, 75, 87 };
        Node root = construct(arr, 0, arr.length - 1);
        display(root);
        System.out.println("Sum: " + sum(root));

        System.out.println(find(root, 62));
    }
}
