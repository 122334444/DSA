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

    // optimal
    public boolean isBalanced2(Node root) {
        int a = maxDepth(root);
        if (a == -1)
            return false;
        return true;
    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        if (lh == -1 || rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }
}
