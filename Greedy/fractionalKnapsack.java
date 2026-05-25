package Greedy;

import java.util.*;

public class fractionalKnapsack {

    static class Item {
        int wt, val;
        double ratio;

        Item(int wt, int val) {
            this.wt = wt;
            this.val = val;
            this.ratio = (double) val / wt;
        }
    }

    public static double frKnapsack(int wt[], int val[], int W) {

        Item arr[] = new Item[wt.length];

        for (int i = 0; i < wt.length; i++) {
            arr[i] = new Item(wt[i], val[i]);
        }

        Arrays.sort(arr, (a, b) -> Double.compare(b.ratio, a.ratio));

        double ans = 0;

        for (Item it : arr) {

            if (W >= it.wt) {
                ans += it.val;
                W -= it.wt;
            } else {
                ans += it.ratio * W;
                break;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int wt[] = { 20, 10, 50, 50 };
        int val[] = { 100, 60, 100, 200 };
        int capacity = 90;

        System.out.println(frKnapsack(wt, val, capacity));
    }
}