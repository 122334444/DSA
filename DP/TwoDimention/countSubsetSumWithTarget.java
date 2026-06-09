package DP.TwoDimention;

import DP.dpOnSubsequences.targetSumWays;
import java.util.*;

public class countSubsetSumWithTarget {
    // memo
    public static int countSub(int arr[], int target, int idx, int dp[][]) {
        int n = arr.length;
        if (target == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (idx < 0) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }
        int notpick = countSub(arr, target, idx - 1, dp);
        int pick = 0;
        if (arr[idx] <= target) {
            pick = countSub(arr, target - arr[idx], idx - 1, dp);
        }
        return dp[idx][target] = (pick + notpick);
    }

    // top down
    public static int countSubTopDown(int arr[], int target) {
        int n = arr.length;
        int dp[][] = new int[n][target + 1];
        return 1;
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 5, 6, 8, 10 };
        int sum = 10;
        int n = arr.length;
        int dp[][] = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.print(countSub(arr, sum, arr.length - 1, dp));
    }
}
