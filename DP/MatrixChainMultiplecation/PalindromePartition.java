package DP.MatrixChainMultiplecation;

import java.util.*;

public class PalindromePartition {
    // make minimum partition in a string such that all parts are palindrome

    public static int RecMemo(String s, int i, int j, int dp[][]) {
        if (i >= j) {// either empty or length 1
            return 0;
        }

        if (isPalindrome(s, i, j)) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int temp = RecMemo(s, i, k, dp) + RecMemo(s, k + 1, j, dp) + 1;
            ans = Math.min(ans, temp);
        }
        return dp[i][j] = ans;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        if (i == j)
            return true;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String args[]) {
        String s = "vivkik";

        int n = s.length();

        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(RecMemo(s, 0, n - 1, dp));

    }
}
