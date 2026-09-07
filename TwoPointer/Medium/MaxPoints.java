package TwoPointer.Medium;

//Leetcode 1423
public class MaxPoints {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int lSum = 0, rSum = 0;

        for (int i = 0; i < k; i++) {
            lSum += nums[i];
        }

        int maxSum = lSum;
        int ri = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            lSum -= nums[i];
            rSum += nums[ri];
            maxSum = Math.max(maxSum, lSum + rSum);
            ri--;
        }
        return maxSum;
    }
}
