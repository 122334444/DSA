package DP.dpOnStrings;

import java.util.Arrays;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(n - 1, m - 1, word1, word2, dp);
    }

    private int f(int i, int j, String s1, String s2, int dp[][]) {

        // Base case
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 0 + f(i - 1, j - 1, s1, s2, dp);// ek match ho gya kuchh nahi karna hai
        }
        int a = 1 + f(i - 1, j - 1, s1, s2, dp);// 1step-> Replace
        int b = 1 + f(i, j - 1, s1, s2, dp);// 1 step -> inserting
        int c = 1 + f(i - 1, j, s1, s2, dp);// 1 step -> deletion
        return dp[i][j] = Math.min(a, Math.min(b, c));
    }
}
