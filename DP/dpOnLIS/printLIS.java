package DP.dpOnLIS;

import java.util.*;

public class printLIS {

    public static void printLIS(int[] arr) {
        int n = arr.length;

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> lis = new ArrayList<>();

        while (lastIndex != -1) {
            lis.add(arr[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        Collections.reverse(lis);

        System.out.println("Length of LIS = " + maxLen);
        System.out.println("LIS = " + lis);
    }

    public static void main(String args[]) {
        int arr[] = { 3, 4, 2, 1, 4, 5, 6, 7, 8, 4, 32, 1, 5 };
        printLIS(arr);
    }
}