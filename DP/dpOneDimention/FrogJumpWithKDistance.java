package DP.dpOneDimention;

import java.util.Arrays;

public class FrogJumpWithKDistance {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, heights, k, dp);
    }

    private int solve(int idx, int heights[], int k, int dp[]) {

        if (idx == 0)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        int cost = Integer.MAX_VALUE;
        for (int i = 1; i <= k && idx - i >= 0; i++) {
            int temp = Math.abs(heights[idx] - heights[idx - i]) + solve(idx - i, heights, k, dp);
            cost = Math.min(cost, temp);
        }
        return dp[idx] = cost;
    }
}
