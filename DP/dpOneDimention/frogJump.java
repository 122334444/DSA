package DP.dpOneDimention;

import java.util.*;

public class FrogJump {

    public static int frogJump(int idx, int[] h, int dp[]) {

        // Base case
        if (idx == 0)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        // Jump from previous stair
        int left = frogJump(idx - 1, h, dp) + Math.abs(h[idx] - h[idx - 1]);

        int right = Integer.MAX_VALUE;

        // Jump from two stairs back
        if (idx > 1) {
            right = frogJump(idx - 2, h, dp) + Math.abs(h[idx] - h[idx - 2]);
        }

        // Minimum energy
        return dp[idx] = Math.min(left, right);
    }

    public static void main(String[] args) {

        int[] height = { 30, 10, 60, 10, 60, 50 };

        int n = height.length;

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(frogJump(n - 1, height, dp));
    }
}
