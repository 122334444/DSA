package DP.dpOnSubsequences;

public class targetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return f(n - 1, 0, target, nums);
    }

    private int f(int idx, int s, int target, int nums[]) {
        if (idx < 0) {// should also consider 0th idx
            return s == target ? 1 : 0;
        }

        int add = f(idx - 1, s + nums[idx], target, nums);
        int sub = f(idx - 1, s - nums[idx], target, nums);
        return add + sub;// Number of all ways
    }

    // Q. Given an array and a target aim is to find number of ways in which target
    // can be find by only + & -
    // LeetCode 494
}
