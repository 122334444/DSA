package Arrays.Medium;

//bruteforce -> count 0,1,2 and then put in the same array -> TC=O(2N)
//optimal -> Duch flag method
public class sort012 {

    // optimal
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {// nums[mid==2]
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String args[]) {
        int arr[] = { 0, 1, 2, 2, 2, 0, 1, 1, 1, 0 };
        sortColors(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
