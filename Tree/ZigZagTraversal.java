package Tree;

import java.util.*;

//leetcode 103
public class ZigZagTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;// to detect left to right or right to left

        while (!q.isEmpty()) {
            int sz = q.size();
            Integer[] arr = new Integer[sz];
            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();
                int idx = flag ? i : sz - 1 - i;
                arr[idx] = curr.val;
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            res.add(Arrays.asList(arr));
            flag = !flag;
        }
        return res;
    }
}
