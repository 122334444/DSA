package DP.dpOneDimention;

public class zeroOneKnapsack {

    public static int knapsack(int wt[], int val[], int w, int idx) {
        if (idx < 0 || w == 0) {
            return 0;
        }

        if (wt[idx] <= w) {
            return Math.max(val[idx] + knapsack(wt, val, w - wt[idx], idx - 1), knapsack(wt, val, w, idx - 1));
        } else {
            return knapsack(wt, val, w, idx - 1);
        }

    }

    public static void main(String args[]) {
        int wt[] = { 1, 3, 4, 5 };
        int val[] = { 1, 4, 5, 7 };
        int w = 7;
        int n = wt.length;
        System.out.println(knapsack(wt, val, w, n - 1));
    }
}
