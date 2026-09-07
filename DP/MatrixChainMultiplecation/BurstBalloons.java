package DP.MatrixChainMultiplecation;

import java.util.Arrays;

public class BurstBalloons {

    private static int f(int i, int j, int nums[], int dp[][]) {
        if (i > j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int max = 0;
        for (int idx = i; idx <= j; idx++) {
            int cost = nums[i - 1] * nums[idx] * nums[j + 1] + f(i, idx - 1, nums, dp) + f(idx + 1, j, nums, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 1, 5, 8 };
        int n = nums.length;

        int arr[] = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int dp[][] = new int[n + 1][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int ans = f(1, n, arr, dp);

        System.out.println(ans);
    }
}
