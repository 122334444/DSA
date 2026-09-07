package BST;

public class CheckIfBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long l, long r) {
        if (root == null)
            return true;
        if (root.val >= r || root.val <= l)
            return false;

        return isValid(root.left, l, root.val) && isValid(root.right, root.val, r);
    }
}
