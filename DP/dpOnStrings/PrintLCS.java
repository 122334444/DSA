package DP.dpOnStrings;

import LinkedList.reverse;

public class PrintLCS {

    public static void longestCommonSubsequence(String x, String y, int dp[][]) {
        int n = x.length();
        int m = y.length();

        // initialisation
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

    }

    public static void main(String args[]) {
        String s1 = "acbcf";
        String s2 = "abcdaf";

        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        longestCommonSubsequence(s1, s2, dp);

        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        String ans = sb.reverse().toString();

        System.out.println(ans);

    }
}
