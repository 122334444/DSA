package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    class Pair {
        int row;
        int val;

        Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    Map<Integer, List<Pair>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, 0);
        for (List<Pair> list : map.values()) {
            // Sort by row first, then value
            Collections.sort(list, (a, b) -> {
                if (a.row != b.row)
                    return a.row - b.row;

                return a.val - b.val;
            });
            List<Integer> temp = new ArrayList<>();
            for (Pair p : list) {
                temp.add(p.val);
            }
            ans.add(temp);
        }
        return ans;
    }

    void dfs(TreeNode root, int row, int col) {
        if (root == null)
            return;

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new Pair(row, root.val));
        // left = col - 1
        dfs(root.left, row + 1, col - 1);
        // right = col + 1
        dfs(root.right, row + 1, col + 1);
    }
}
