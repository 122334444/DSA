package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        solve(0, nums, set, new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> ls : set) {
            ans.add(ls);
        }
        return ans;
    }

    private void solve(int idx, int nums[], Set<List<Integer>> ans, List<Integer> ls) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        // take
        ls.add(nums[idx]);
        solve(idx + 1, nums, ans, ls);
        // not take
        ls.remove(ls.size() - 1);
        solve(idx + 1, nums, ans, ls);
    }
}
