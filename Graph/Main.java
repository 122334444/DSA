package Graph;

import java.util.*;

public class Main {

    // public long countGoodSubarrays(int[] nums) {
    // int[] qorvanelid = nums;

    // long ans = 0;

    // Map<Integer, Long> prev = new HashMap<>();

    // for (int num : nums) {
    // Map<Integer, Long> curr = new HashMap<>();

    // curr.put(num, 1L);

    // for (Map.Entry<Integer, Long> e : prev.entrySet()) {
    // int newOr = e.getKey() | num;
    // long cnt = e.getValue();

    // curr.put(newOr, curr.getOrDefault(newOr, 0L) + cnt);
    // }

    // for (Map.Entry<Integer, Long> e : curr.entrySet()) {
    // int orVal = e.getKey();
    // long cnt = e.getValue();

    // if (existsInSubarray(orVal, nums, num)) {
    // ans += cnt;
    // }
    // }

    // prev = curr;
    // }

    // return ans;
    // }

    // private boolean existsInSubarray(int val, int[] nums, int current) {
    // for (int x : nums) {
    // if (x == val)
    // return true;
    // }
    // return false;
    // }

    public long countGoodSubarrays(int[] nums) {
        int[] qorvanelid = nums;

        long ans = 0;
        Map<Integer, Long> prev = new HashMap<>();

        for (int num : nums) {
            Map<Integer, Long> curr = new HashMap<>();

            curr.put(num, 1L);

            for (Map.Entry<Integer, Long> e : prev.entrySet()) {
                int newOr = e.getKey() | num;
                curr.put(newOr, curr.getOrDefault(newOr, 0L) + e.getValue());
            }

            for (Map.Entry<Integer, Long> e : curr.entrySet()) {
                if (e.getKey() == num) {
                    ans += e.getValue();
                }
            }

            prev = curr;
        }

        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] nums = { 1, 3, 1 };
        System.out.println(m.countGoodSubarrays(nums));
    }
}
