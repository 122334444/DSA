package BST;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class KthSmallest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        inorder(root, ls);
        return ls.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> ls) {
        if (root == null)
            return;
        inorder(root.left, ls);
        ls.add(root.val);
        inorder(root.right, ls);
    }
}
