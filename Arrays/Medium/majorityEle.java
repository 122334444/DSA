package Arrays.Medium;

public class majorityEle {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0, ele = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count++;
                ele = nums[i];
            } else if (nums[i] == ele) {
                count++;
            } else {
                count--;// foor other elements
            }
        }
        return ele;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 5, 43, 2, 2, 2, 5, 2, 2, 7 };
        System.out.println(majorityElement(arr));
    }

}
