package TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class subarraysWithKdiffIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // num of sub less or equal to k diff int - sub leass or equal to k-1
        return subWithLessKdiffInt(nums, k) - subWithLessKdiffInt(nums, k - 1);
    }

    public int subWithLessKdiffInt(int[] nums, int k) {
        int l = 0, r = 0, count = 0;// counts subarrays with ,+ k diff integers
        Map<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}
