
public class MinFallingSum {

    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int dp[][] = new int[n][m];

        //initialisation
        for (int j = 0; j < m; j++) {
            dp[0][j] = mat[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j > 0 && j < m - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + mat[i][j];
                }
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + mat[i][j];
                }
                if (j == m - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + mat[i][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }

        return ans;
    }

    public static void main(String args[]) {

    }
}
