package DP.TwoDimention;

public class subsetSuMTarget {

    // MEMOIZATION
    private static boolean subSum(int arr[], int idx, int target, Boolean dp[][]) {

        if (target == 0)
            return true;
        if (idx == 0)
            return arr[0] == target;

        if (dp[idx][target] != null)
            return dp[idx][target];
        // not pick
        boolean notPick = subSum(arr, idx - 1, target, dp);
        // pick
        boolean pick = false;
        if (target >= arr[idx]) {
            pick = subSum(arr, idx - 1, target - arr[idx], dp);
        }
        // not pick

        return dp[idx][target] = (pick || notPick);
    }

    // tabulation
    private static boolean subSumT(int arr[], int target) {
        int n = arr.length;
        boolean dp[][] = new boolean[n][target + 1];

        for (int i = 0; i < n; i++) {// base case
            dp[i][0] = true;
        }

        if (arr[0] <= target)
            dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean notPick = dp[i - 1][t];

                boolean pick = false;
                if (t > arr[i]) {
                    pick = dp[i - 1][t - arr[i]];
                }
                dp[i][t] = (pick || notPick);
            }
        }

        return dp[n - 1][target];

    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 5, 3, 6, 8, 2 };
        int n = arr.length;
        int target = 7;
        Boolean dp[][] = new Boolean[n][target + 1];
        System.out.println(subSum(arr, n - 1, target, dp));

        System.out.println(subSumT(arr, target));
    }
}
