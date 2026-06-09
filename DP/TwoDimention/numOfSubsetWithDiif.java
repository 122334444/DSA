package DP.TwoDimention;

import java.util.*;

public class numOfSubsetWithDiif {

    static int solve(int idx, int target, int[] arr, int[][] dp) {

        if (idx == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        if (dp[idx][target] != -1)
            return dp[idx][target];

        int notPick = solve(idx - 1, target, arr, dp);

        int pick = 0;
        if (arr[idx] <= target)
            pick = solve(idx - 1, target - arr[idx], arr, dp);

        return dp[idx][target] = pick + notPick;
    }

    static int countPartitions(int[] arr, int d) {

        int n = arr.length;
        int totalSum = 0;

        for (int num : arr)
            totalSum += num;

        if (totalSum - d < 0 || (totalSum - d) % 2 != 0)
            return 0;

        int target = (totalSum - d) / 2;

        int[][] dp = new int[n][target + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(n - 1, target, arr, dp);
    }

    public static void main(String[] args) {

        int[] arr = { 1, 1, 2, 3 };
        int d = 1;

        System.out.println(countPartitions(arr, d));
    }
}
