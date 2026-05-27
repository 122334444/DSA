package Greedy;

import java.util.Arrays;

//leetcode 135
public class candies {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int cand[] = new int[n];
        Arrays.fill(cand, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                cand[i] = cand[i - 1] + 1;
            }
        }

        int count = 0;
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                cand[i - 1] = Math.max(cand[i] + 1, cand[i - 1]);
            }
            count += cand[i - 1];
        }

        return count + cand[n - 1];
    }
}
