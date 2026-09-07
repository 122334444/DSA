package DP.dpOneDimention;

import java.util.*;

//CODE FORCES LINK: https://codeforces.com/problemset/problem/2208/C

//one of the best use case of house robber

public class houserobberbased {

    public static double solve(int c[], int p[], int idx, double dp[]) {
        if (idx >= c.length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        double pick = c[idx] + (1 - p[idx] / 100.0) * solve(c, p, idx + 1, dp);
        double notPick = solve(c, p, idx + 1, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    public static void main(String args[]) {

        int c[] = { 100, 200, 300, 400, 500 };
        int p[] = { 10, 20, 30, 40, 50 };
        int n = c.length;

        double dp[] = new double[n];
        Arrays.fill(dp, -1);

        double ans = solve(c, p, 0, dp);
        System.out.println(ans);

    }
}