
import java.util.*;

class CountSubsWithGivenSum {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int preSum = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int needToRemove = preSum - k;

            count += map.getOrDefault(needToRemove, 0);

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
