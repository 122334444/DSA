package DP.MatrixChainMultiplecation;

import java.util.Arrays;

//Leet code 1563
public class StoneGame5 {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        if (n == 1)
            return 0;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int preSum[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stoneValue[i];
        }

        return solve(0, n - 1, preSum, dp);
    }

    private int solve(int l, int r, int preSum[], int dp[][]) {
        if (l == r)
            return 0;
        int ans = 0;
        if (dp[l][r] != -1)
            return dp[l][r];
        for (int k = l; k < r; k++) {
            int lSum = preSum[k + 1] - preSum[l];
            int rSum = preSum[r + 1] - preSum[k + 1];
            if (lSum < rSum) {
                int score = lSum + solve(l, k, preSum, dp);
                ans = Math.max(ans, score);
            } else if (lSum > rSum) {
                int score = rSum + solve(k + 1, r, preSum, dp);
                ans = Math.max(ans, score);
            } else {
                int leftScore = solve(l, k, preSum, dp);
                int rightScore = solve(k + 1, r, preSum, dp);
                int score = lSum + Math.max(leftScore, rightScore);
                ans = Math.max(ans, score);
            }
        }
        return dp[l][r] = ans;
    }
}
