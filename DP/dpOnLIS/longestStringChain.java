package DP.dpOnLIS;
//Leetcode 1048 -> fully LIS based 

import java.util.Arrays;

public class longestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int dp[][] = new int[n][n + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return solve(0, -1, words, dp);
    }

    private int solve(int idx, int prevIdx, String[] words, int dp[][]) {
        if (idx == words.length)
            return 0;

        if (dp[idx][prevIdx + 1] != -1)
            return dp[idx][prevIdx + 1];

        int notPick = 0 + solve(idx + 1, prevIdx, words, dp);
        int pick = -1;
        if (prevIdx == -1 || valid(words[prevIdx], words[idx])) {
            pick = 1 + solve(idx + 1, idx, words, dp);
        }

        return dp[idx][prevIdx + 1] = Math.max(pick, notPick);
    }

    private boolean valid(String s1, String s2) {
        if (s2.length() - s1.length() != 1)
            return false;

        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s1.length();
    }

    public static void main(String args[]) {

    }
}
