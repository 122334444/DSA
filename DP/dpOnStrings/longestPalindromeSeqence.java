package DP.dpOnStrings;

public class longestPalindromeSeqence {
    public String longestPalindrome(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        return lcs(s, s1);
    }

    private String lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int maxLen = 0;
        int endIndex = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (dp[i][j] > maxLen) {

                    int originalStart = i - dp[i][j];
                    int reverseStart = n - j;

                    // Important validity check
                    if (originalStart == reverseStart) {

                        maxLen = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        return s1.substring(endIndex - maxLen, endIndex);
    }
}
