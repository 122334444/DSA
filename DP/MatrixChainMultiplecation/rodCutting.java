package DP.MatrixChainMultiplecation;

import java.util.*;

public class rodCutting {

    // knapsack approach
    static int solve(int[] price, int n, int idx, int[][] dp) {

        // Base case
        if (idx == 0) {
            return n * price[0];// means cutting all part of length 1
        }

        if (dp[idx][n] != -1) {
            return dp[idx][n];
        }

        int notPick = solve(price, n, idx - 1, dp);

        int pick = Integer.MIN_VALUE;
        int rodLength = idx + 1;

        if (rodLength <= n) {
            pick = price[idx] + solve(price, n - rodLength, idx, dp);/// change in rod length ->
        }

        return dp[idx][n] = Math.max(pick, notPick);
    }

    public static int rodCutting(int n, int price[]) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return fxn(n, price, dp);
    }

    private static int fxn(int n, int price[], int dp[]) {
        if (n == 0)
            return 0;

        if (dp[n] != -1) {
            return dp[n];
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, price[i - 1] + fxn(n - i, price, dp));// rod lenth change
        }
        return dp[n] = max;
    }

    public static void main(String args[]) {
        int price[] = { 3, 5, 8, 9, 10, 17, 17, 20 };

        int n = price.length;// length of rod
        int dp[][] = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(price, n, n - 1, dp));
        System.out.println(rodCutting(n, price));
    }
}
