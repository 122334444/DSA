package BinarySearch;

public class MinInRotSorted {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int min = nums[0];
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[l] <= nums[mid]) {// left sorted -> go in right
                min = Math.min(min, nums[l]);
                l = mid + 1;
            } else {// right sorted -> search in left
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            }
        }
        return min;
    }
    /// ALSO THE INDEX OF MINIMUM NUMBER WILL BE THE NUMBER OF TIMES THE ARRAY HAS
    /// BEEN ROTATED
}
