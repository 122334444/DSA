package TwoPointer.Medium;

import java.util.HashSet;
import java.util.Set;

//Fruits in Baskets: Find the longest contiguous subarray containing at most 2 distinct types of fruits (i.e., at most 2 different numbers).
public class FruitsInBasket {

    public int totalFruits(int[] fruits) {
        int n = fruits.length;
        Set<Integer> set = new HashSet<>();
        int l = 0, r = 0;
        int max = 0;

        while (r < n) {
            while (set.size() > 2) {
                set.remove(fruits[l]);
                l++;
            }
            max = Math.max(max, r - l + 1);
            set.add(fruits[r]);
            r++;
        }
        return max;
    }
}
