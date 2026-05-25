package Greedy;

//leetcode 55
public class jumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (maxIdx < i) {
                return false;
            }
            maxIdx = Math.max(maxIdx, i + nums[i]);
        }
        return maxIdx >= n - 1;
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 1, 1, 4 };
        int arr2[] = { 3, 2, 1, 0, 4 };

        System.out.println(canJump(arr));
        System.out.println(canJump(arr2));
    }
}
