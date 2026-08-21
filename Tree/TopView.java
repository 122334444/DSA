package Tree;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    class Pair {
        TreeNode node;
        int score;

        Pair(TreeNode node, int score) {
            this.node = node;
            this.score = score;
        }
    }

    public List<Integer> topView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair p = q.remove();

            TreeNode node = p.node;
            int score = p.score;

            // First node at this score = top view
            if (!map.containsKey(score)) {
                map.put(score, node.val);
            }

            if (node.left != null) {
                q.add(new Pair(node.left, score - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, score + 1));
            }
        }

        // TreeMap gives left to right order
        for (int val : map.values()) {
            ans.add(val);
        }

        return ans;
    }
}
