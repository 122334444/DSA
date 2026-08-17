package Tree;

import javax.swing.tree.TreeNode;

public class BalancedTree {

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

    public boolean isBalanced(Node root) {
        if (root == null)
            return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) > 1)
            return false;

        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);
        if (!l || !r)
            return false;

        return true;
    }

    private int height(Node root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);
    }
}
