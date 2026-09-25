package TwoPointer.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Leet Code 2958
//You are given an integer array nums and an integer k.
//The frequency of an element x is the number of times it occurs in an array.
//An array is called good if the frequency of each element in this array is less than or equal to k.
//Return the length of the longest good subarray of nums.

public class LOngestSubWithAtMostKfreq {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        Set<Integer> hs = new HashSet<>();
        int max = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        while (r < n) {
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            while (freq.get(nums[r]) > k) {
                int leftValue = nums[l];
                freq.put(leftValue, freq.get(leftValue) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
