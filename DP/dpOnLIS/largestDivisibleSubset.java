package DP.dpOnLIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//368 leet code Given a set of distinct positive integers nums, return the largest subset answer 

//such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
// answer[i] % answer[j] == 0, or
// answer[j] % answer[i] == 0
// If there are multiple solutions, return any of them.

public class largestDivisibleSubset {

    public static List<Integer> lds(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxi = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxi])
                maxi = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = maxi; i >= 0; i = prev[i]) {
            res.add(nums[i]);
        }
        return res;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 4, 3, 2, 5, 6, 8, 16, 24, 20, 32, 12, 13, 23 };

        List<Integer> ans = lds(nums);
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
