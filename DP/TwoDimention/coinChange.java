package DP.TwoDimention;

import java.util.*;

class coinChange {

    // memoization
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = solve(n - 1, coins, amount, dp);
        return ans >= 1000000000 ? -1 : ans;
    }

    private int solve(int idx, int arr[], int target, int dp[][]) {
        if (idx == 0) {
            if (target % arr[idx] == 0) {
                return target / arr[idx];
            } else {
                return 1000000000;
            }
        }

        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }

        int notTake = solve(idx - 1, arr, target, dp);
        int take = 1000000000;

        if (target >= arr[idx]) {
            take = 1 + solve(idx, arr, target - arr[idx], dp);
        }

        return dp[idx][target] = Math.min(take, notTake);
    }

    // Tabulatiion

    public static void main(String args[]) {
        coinChange cc = new coinChange();
        int arr[] = { 1, 2, 5 };
        int amount = 11;
        System.out.println(cc.coinChange(arr, amount));
    }
}
