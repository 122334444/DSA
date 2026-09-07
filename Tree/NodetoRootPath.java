package Tree;

import java.util.*;

public class NodetoRootPath {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static ArrayList<Integer> path;

    public static boolean find(Node root, int target) {
        if (root == null) {
            return false;
        }
        if (root.data == target) {
            path.add(root.data);
            return true;
        }

        boolean lc = find(root.left, target);
        if (lc) {
            path.add(root.data);
            return true;
        }

        boolean rc = find(root.right, target);
        if (rc) {
            path.add(root.data);
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        path = new ArrayList<>();

        int target = 10;

        boolean found = find(root, target);

        if (found) {
            System.out.println("Node to Root Path: " + path);
        } else {
            System.out.println("Node not found");
        }
    }
}
