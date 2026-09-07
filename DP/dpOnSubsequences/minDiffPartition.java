package DP.dpOnSubsequences;

//leet code 2035
public class minDiffPartition {
    int ans = Integer.MAX_VALUE;
    boolean[][][] dp;

    public int minimumDifference(int[] nums) {

        int n = nums.length;

        int total = 0;

        for (int x : nums) {
            total += x;
        }

        dp = new boolean[n][n / 2 + 1][total + 1];

        f(n - 1, 0, n / 2, total, nums);

        return ans;
    }

    public void f(int idx, int sum, int len, int total, int[] arr) {

        if (len == 0) {
            ans = Math.min(ans, Math.abs(total - 2 * sum));
            return;
        }

        if (idx < 0)
            return;

        if (dp[idx][len][sum])
            return;

        dp[idx][len][sum] = true;

        // take
        f(idx - 1, sum + arr[idx], len - 1, total, arr);

        // not take
        f(idx - 1, sum, len, total, arr);
    }
}
