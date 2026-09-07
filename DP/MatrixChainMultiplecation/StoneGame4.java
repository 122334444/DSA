package DP.MatrixChainMultiplecation;

import java.util.Arrays;

//Leetcode: 1510
public class StoneGame4 {
    public boolean winnerSquareGame(int n) {

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans = solve(n, dp);
        if (ans == 1)
            return true;
        return false;
    }

    private int solve(int n, int dp[]) {
        if (n <= 0) {// alis turn aur sq
            return 0;
        }

        if (dp[n] != -1)
            return dp[n];

        for (int i = 1; i * i <= n; i++) {
            if (solve(n - i * i, dp) == 0) {
                return dp[n] = 1;
            }
        }
        return dp[n] = 0;
    }
}
