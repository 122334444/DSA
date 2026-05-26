package Greedy;

public class jumpGameII {

    public static int jump(int[] nums) {
        int n = nums.length;

        int jump = 0, l = 0, r = 0;

        while (r < n - 1) {
            int far = 0;
            for (int i = l; i <= r; i++) {
                far = Math.max(far, i + nums[i]);
            }
            l = r + 1;
            r = far;
            jump = jump + 1;
        }
        return jump;
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 1, 1, 4 };
        System.out.println(jump(arr));
    }
}
