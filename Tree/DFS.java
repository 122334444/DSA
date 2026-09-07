package Tree;

public class DFS {

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

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        preorder(root.left);
        System.out.print(root.data + " ");
        preorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }

        preorder(root.left);

        preorder(root.right);
        System.out.print(root.data + " ");
    }

}
