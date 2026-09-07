package DP.dpOnSubsequences;

public class partitionEqualSumSuset {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        if (s % 2 != 0)
            return false;
        int target = s / 2;

        Boolean dp[][] = new Boolean[n][target + 1];

        return f(n - 1, target, nums, dp);
    }

    public boolean f(int idx, int target, int nums[], Boolean dp[][]) {
        if (target == 0)
            return true;
        if (idx == 0)
            return target == nums[idx];

        if (dp[idx][target] != null)
            return dp[idx][target];
        boolean noPick = f(idx - 1, target, nums, dp);
        // pick
        boolean pick = false;
        if (nums[idx] <= target) {
            pick = f(idx - 1, target - nums[idx], nums, dp);
        }
        return dp[idx][target] = (pick || noPick);
    }
}
