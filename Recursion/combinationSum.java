package Recursion;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int idx, int nums[], int target, List<Integer> ls, List<List<Integer>> ans) {
        if (idx == nums.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ls));
            }
            return;
        }
        if (nums[idx] <= target) {
            ls.add(nums[idx]);
            solve(idx, nums, target - nums[idx], ls, ans);
            ls.remove(ls.size() - 1);
        }
        // if not possible to take or leaviing case
        solve(idx + 1, nums, target, ls, ans);

    }
}
