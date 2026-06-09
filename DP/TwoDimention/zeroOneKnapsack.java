package DP.TwoDimention;

import java.util.*;

public class zeroOneKnapsack {

    public static int knapsack(int wt[], int val[], int w, int idx, int dp[][]) {
        if (idx < 0 || w == 0) {
            return 0;
        }
        if (dp[idx][w] != -1)
            return dp[idx][w];

        int notPick = knapsack(wt, val, w, idx - 1, dp);

        int pick = Integer.MIN_VALUE;
        if (wt[idx] <= w) {
            pick = Math.max(val[idx] + knapsack(wt, val, w - wt[idx], idx - 1, dp), pick);
        }

        return Math.max(pick, notPick);

    }

    public static int knapsackTopDown(int wt[], int val[], int w) {
        int n = wt.length;

        int dp[][] = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String args[]) {
        int wt[] = { 1, 3, 4, 5 };
        int val[] = { 1, 4, 5, 7 };
        int w = 7;
        int n = wt.length;
        int dp[][] = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(knapsack(wt, val, w, n - 1, dp));
        System.out.println(knapsackTopDown(wt, val, w));
    }
}
