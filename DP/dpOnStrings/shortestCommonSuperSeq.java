package DP.dpOnStrings;

public class shortestCommonSuperSeq {

    public static int lcs(String x, String y) {
        int n = x.length();
        int m = y.length();

        int dp[][] = new int[n + 1][m + 1];

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

        return dp[n][m];

    }

    public static int shortstSuperSeq(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        return n + m - lcs(s1, s2);
    }

    public static void main(String args[]) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(shortstSuperSeq(s1, s2));
    }
}
