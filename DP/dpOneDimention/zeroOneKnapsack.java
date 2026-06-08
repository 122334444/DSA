package DP.dpOneDimention;

import java.util.*;

public class zeroOneKnapsack {

    public static int knapsack(int wt[], int val[], int w, int idx, int dp[][]) {
        if (idx < 0 || w == 0) {
            return 0;
        }
        if (dp[idx][w] != -1)
            return dp[idx][w];

        if (wt[idx] <= w) {
            return dp[idx][w] = Math.max(val[idx] + knapsack(wt, val, w - wt[idx], idx - 1, dp),
                    knapsack(wt, val, w, idx - 1, dp));
        } else {
            return dp[idx][w] = knapsack(wt, val, w, idx - 1, dp);
        }

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
    }
}
