package Arrays.Hard;

public class minInRotSorted {
    public int findMin(int[] nums) {
        int n = nums.length;

        int l = 0, r = n - 1;
        int ans = Integer.MAX_VALUE;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }// hard because duplicates are also there in the array -> also works for arr
     // with no duplicate elements
}
