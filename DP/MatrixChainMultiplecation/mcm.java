package DP.MatrixChainMultiplecation;

import java.util.*;

public class mcm {

    public static int matChainMult(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j]
                            + arr[i - 1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }

    // REC+MEMO
    public static int recursiveMCM(int arr[], int i, int j, int dp[][]) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int left = recursiveMCM(arr, i, k, dp);
            int right = recursiveMCM(arr, k + 1, j, dp);
            int tempAns = left + right + arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, tempAns);

        }
        return dp[i][j] = ans;
    }

    public static void main(String args[]) {
        int arr[] = { 40, 20, 30, 10, 30 };
        int n = arr.length;
        System.out.println(matChainMult(arr));

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recursiveMCM(arr, 1, n - 1, dp));
    }
}
