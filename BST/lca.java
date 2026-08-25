package BST;

public class lca {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null)
            return null;
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;// equal case
    }

    public static void main(String args[]) {
        Node root = new Node(20, null, null);
        root.left = new Node(10, null, null);
        root.right = new Node(30, null, null);
        root.left.left = new Node(5, null, null);
        root.left.right = new Node(15, null, null);
        root.right.left = new Node(25, null, null);
        root.right.right = new Node(35, null, null);
    }
}
