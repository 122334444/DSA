package DP.MatrixChainMultiplecation;

public class StoneGameII {
    private int solve(int[] piles, int[][][] dp, int turn, int i, int m) {

        int n = piles.length;

        if (i == n) {
            return 0;
        }

        if (dp[turn][i][m] != -1) {
            return dp[turn][i][m];
        }

        int res = (turn == 1) ? 1000000 : -1;
        int score = 0;

        for (int x = 1; x <= Math.min(2 * m, n - i); x++) {

            score += piles[i + x - 1];

            if (turn == 0) {
                res = Math.max(
                        res,
                        score + solve(piles, dp, 1, i + x, Math.max(m, x)));
            } else {
                res = Math.min(res, solve(piles, dp, 0, i + x, Math.max(m, x)));
            }
        }
        return dp[turn][i][m] = res;
    }

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        int[][][] dp = new int[2][n + 1][n + 1];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= n; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(piles, dp, 0, 0, 1);
    }
}
