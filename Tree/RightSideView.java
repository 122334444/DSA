package Tree;

import java.util.*;

public class RightSideView {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levels = levelOrder(root);

        List<Integer> res = new ArrayList<>();
        for (List<Integer> ls : levels) {
            res.add(ls.get(ls.size() - 1));
        }
        return res;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> ls = new ArrayList<>();// stores elements in leve
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                ls.add(curr.val);
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            ans.add(ls);
        }
        return ans;
    }

    public static void main(String args[]) {

    }
}
