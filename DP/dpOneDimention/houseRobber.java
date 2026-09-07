package DP.dpOneDimention;

import java.util.Arrays;

public class houseRobber {

    public static int rob(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return function(n - 1, nums, dp);
    }

    public static int function(int idx, int nums[], int dp[]) {

        if (idx < 0)
            return 0;

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int pick = function(idx - 2, nums, dp) + nums[idx];
        int notPick = function(idx - 1, nums, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    public static void main(String args[]) {
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums));
    }
}
