package DP.dpOnSquare;

public class CountSquaresWith1 {
    public int countSquares(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[i][j] = mat[i][j];
                }
                if (j == 0) {
                    dp[i][j] = mat[i][j];
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += dp[i][j];
            }
        }

        return ans;
    }
}
