package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

//leetcode 992
public class subArayWithKdiffInt {

    private static int atMost(int[] nums, int k) {

        int n = nums.length;

        int left = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {

            map.put(nums[right],
                    map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {

                map.put(nums[left],
                        map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 1, 2, 3 };
        int k = 2;

        int ans = atMost(nums, k) - atMost(nums, k - 1);

        System.out.println(ans);

    }
}
