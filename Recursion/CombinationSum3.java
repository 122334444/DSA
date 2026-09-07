package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(9, k, n, ans, new ArrayList<>());
        return ans;
    }

    private void solve(int num, int k, int n, List<List<Integer>> ans, List<Integer> ls) {
        if (num == 0) {
            if (k == 0 && n == 0) {
                ans.add(new ArrayList<>(ls));
            }
            return;
        }
        // take
        if (n >= num) {
            ls.add(num);
            solve(num - 1, k - 1, n - num, ans, ls);
            ls.remove(ls.size() - 1);
        }
        // not take
        solve(num - 1, k, n, ans, ls);
    }
}
