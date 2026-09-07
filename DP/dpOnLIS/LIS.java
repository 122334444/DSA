package DP.dpOnLIS;

import java.util.Arrays;

public class LIS {// LONGEST INCREASING SUB-SEQUENCE

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(0, -1, nums, dp);
    }

    public static int solve(int idx, int prevIdx, int nums[], int dp[][]) {
        if (idx == nums.length)
            return 0;

        if (dp[idx][prevIdx + 1] != -1)
            return dp[idx][prevIdx + 1];

        // Not take
        int notTake = 0 + solve(idx + 1, prevIdx, nums, dp);
        // take
        int take = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            take = 1 + solve(idx + 1, idx, nums, dp);
        }
        return dp[idx][prevIdx + 1] = Math.max(take, notTake);
    }

    public static void main(String args[]) {
        int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));
    }
}
