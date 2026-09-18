
class AllUniquePaths2 {

    //Leetcode 63
    public int uniquePathsWithObstacles(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int dp[][] = new int[n][m];

        if (mat[0][0] == 1) {
            return 0;
        }

        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            if (mat[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // First row
        for (int j = 1; j < m; j++) {
            if (mat[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
