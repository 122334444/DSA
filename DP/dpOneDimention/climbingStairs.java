package DP.dpOneDimention;

import java.util.*;

///You are climbing a staircase. It takes n steps to reach the top. 
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class climbingStairs {
    public static int climbStairs(int n) {
        int a[] = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    public static int climbStarirRec(int idx, int[] dp) {//
        if (idx == 0)
            return 1;

        if (dp[idx] != -1)
            return dp[idx];
        int l = climbStarirRec(idx - 1, dp);// not adding +1 because we are looking for number ways not steps
        int r = 0;
        if (idx > 1) {
            r = climbStarirRec(idx - 2, dp);
        }
        return dp[idx] = (l + r);// counts all ways
    }

    public static void main(String args[]) {
        int n = 5;
        int dp[] = new int[n + 1];// size n+1 because we need to access 0 to n (n+1 length)
        Arrays.fill(dp, -1);
        System.out.println(climbStarirRec(n, dp));
    }
}
