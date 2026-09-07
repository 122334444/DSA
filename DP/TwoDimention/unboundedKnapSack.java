package DP.TwoDimention;

import java.util.Arrays;

public class unboundedKnapSack {

    // Tabulation
    static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {

        int[][] dp = new int[n][W + 1];

        // Base case
        for (int w = 0; w <= W; w++) {
            dp[0][w] = (w / wt[0]) * val[0];
        }

        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= W; w++) {

                int notTake = dp[i - 1][w];

                int take = 0;
                if (wt[i] <= w) {
                    take = val[i] + dp[i][w - wt[i]];
                }

                dp[i][w] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][W];
    }

    static int solve(int idx, int W, int[] wt, int[] val, int[][] dp) {
        if (idx == 0) {
            return (W / wt[0]) * val[0];
        }

        if (dp[idx][W] != -1) {
            return dp[idx][W];
        }

        int notTake = solve(idx - 1, W, wt, val, dp);

        int take = 0;
        if (wt[idx] <= W) {
            take = val[idx] + solve(idx, W - wt[idx], wt, val, dp);
        }

        return dp[idx][W] = Math.max(take, notTake);
    }

    static int unboundedKnapsackMemo(int n, int W, int[] val, int[] wt) {
        int[][] dp = new int[n][W + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, W, wt, val, dp);
    }
}
