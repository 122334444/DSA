package Tree;

public class SymmetricBT {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return solve(root.left, root.right);
    }

    private boolean solve(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.val != right.val)
            return false;

        return solve(left.left, right.right) && solve(left.right, right.left);
    }
}
