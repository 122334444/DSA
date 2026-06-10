package DP.TwoDimention;

import java.util.*;

public class rodCutting {
    static int solve(int[] price, int n, int idx, int[][] dp) {

        // Base case
        if (idx == 0) {
            return n * price[0];
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

    public static void main(String args[]) {
        int price[] = { 3, 5, 8, 9, 10, 17, 17, 20 };

        int n = price.length;// length of rod
        int dp[][] = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(price, n, n - 1, dp));
    }
}
