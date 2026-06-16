package DP.dpOnStrings;

public class longestCommonSubstring {

    static int maxlen;

    public static int solve(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        int curr = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            curr = 1 + solve(s1, s2, i - 1, j - 1);
            maxlen = Math.max(maxlen, curr);
        }
        // explore all positions
        solve(s1, s2, i - 1, j);
        solve(s1, s2, i, j - 1);

        return curr;
    }

    public static void main(String args[]) {
        String s1 = "abcdef";
        String s2 = "abfce";
        int n = s1.length();
        int m = s2.length();
        solve(s1, s2, n - 1, m - 1);
        System.out.println(maxlen);
    }
}
