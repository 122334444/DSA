package TwoPointer.Medium;

public class MaxConsecutiveOneWithKzeros {

    // Intution is to find the max length of a substring woth atmost k zeros
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int zeros = 0;
        int max = 0;

        while (r < n) {
            if (nums[r] == 0)
                zeros++;
            while (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.print(longestOnes(nums, k));
    }
}
