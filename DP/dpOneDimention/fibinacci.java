package DP.dpOneDimention;

public class fibinacci {
    // memoization
    public static int fib(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }

    // tabulation
    public static int fibTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // space optimization
    public static int fibSpaceOpt(int n) {
        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String args[]) {
        int n = 10;
        int[] dp = new int[n + 1];
        System.out.println(fib(n, dp));
    }
}
