package BST;

public class addNode {

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

    public static Node add(Node root, int data) {
        if (root == null) {
            return new Node(data, null, null);
        }
        if (data > root.data) {
            root.right = add(root.right, data);
        } else if (data < root.data) {
            root.left = add(root.left, data);
        } else {
            // do nothing
        }

        return root;
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

    public static void main(String args[]) {
        Node root = null;
        int arr[] = { 10, 5, 15, 3, 7, 12, 18 };
        for (int i = 0; i < arr.length; i++) {
            root = add(root, arr[i]);
        }
        display(root);
    }
}
