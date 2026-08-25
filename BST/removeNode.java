package BST;

public class removeNode {

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

    public static Node remove(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data > root.data) {
            root.right = remove(root.right, data);
        } else if (data < root.data) {
            root.left = remove(root.left, data);
        } else {// main work will be done here
            if (root.left != null && root.right != null) {
                int lMAx = max(root.left);
                root.data = lMAx;
                root.left = remove(root.left, lMAx);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else if (root.right != null) {
                return root.right;
            } else {// no child
                return null;
            }
        }
        return root;
    }

    public static int max(Node root) {// max in left side
        if (root.right != null) {
            return max(root.right);
        } else {
            return root.data;
        }
    }

    public static void main(String args[]) {
        Node root = new Node(20, null, null);
        root.left = new Node(10, null, null);
        root.right = new Node(30, null, null);
        root.left.left = new Node(5, null, null);
        root.left.right = new Node(15, null, null);
        root.right.left = new Node(25, null, null);
        root.right.right = new Node(35, null, null);

        display(root);

        root = remove(root, 15);

        display(root);
    }
}
