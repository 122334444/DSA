package Arrays.Medium;

public class maxSubarraySum {
    public static int maxSubArray(int[] nums) {
        int max = 0;
        int s = 0;
        for (int x : nums) {
            s += x;
            max = Math.max(max, s);
            if (s < 0)
                s = 0;
        }
        return max;
    }

    public static void main(String args[]) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(arr));
    }

    // brute force O(n^3) and O(n^2)-> check and update at each step in the next
    // loop
}
