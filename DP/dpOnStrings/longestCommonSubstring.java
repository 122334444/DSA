package DP.dpOnStrings;

import java.util.*;

public class LongestCommonSubstring {

    // // Reursive
    // static int maxlen;

    // public static int solve(String s1, String s2, int i, int j) {
    // if (i < 0 || j < 0) {
    // return 0;
    // }
    // int curr = 0;
    // if (s1.charAt(i) == s2.charAt(j)) {
    // curr = 1 + solve(s1, s2, i - 1, j - 1);
    // maxlen = Math.max(maxlen, curr);
    // }
    // // explore all positions
    // solve(s1, s2, i - 1, j);
    // solve(s1, s2, i, j - 1);

    // return curr;
    // }

    // Optimal -> memo
    private int[][] dp;
    private int maxLen;

    private int solve(int i, int j, String s1, String s2) {
        if (i == 0 || j == 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j] = 1 + solve(i - 1, j - 1, s1, s2);
            maxLen = Math.max(maxLen, dp[i][j]);
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }

    public int longestCommonSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        dp = new int[n + 1][m + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        maxLen = 0;

        // Evaluate all states because the answer
        // can end at any position
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                solve(i, j, s1, s2);
            }
        }

        return maxLen;
    }

    public static void main(String args[]) {
        String s1 = "abcdef";
        String s2 = "abfce";
        int n = s1.length();
        int m = s2.length();
        LongestCommonSubstring obj = new LongestCommonSubstring();
        System.out.println(obj.longestCommonSubstring(s1, s2));
    }
}
