package Tree;

import java.util.*;

public class PrintKlevelDown {

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

    static ArrayList<Integer> ls;

    public static void printKlevel(Node root, int k) {
        if (root == null || k < 0) {
            return;
        }

        if (k == 0) {// jaise hi level 0 hua add karo -> har call ke liye
            ls.add(root.data);
        }
        printKlevel(root.left, k - 1);// har baar level reduce karenge to track kt level
        printKlevel(root.right, k - 1);// har baar level reduce karenge to track kt level
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ls = new ArrayList<>();
        printKlevel(root, 2);

        System.out.println(ls);
    }
}
