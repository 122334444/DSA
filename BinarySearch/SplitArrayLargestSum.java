package BinarySearch;

//Leet code 410
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        return findPages(nums, k);
    }

    public int findPages(int[] nums, int m) {
        int n = nums.length;
        int low = maxi(nums), high = sum(nums);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int pages = fxn(nums, mid);
            if (pages > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int fxn(int arr[], int pages) {
        int stu = 1;
        int pagesStu = 0;
        for (int i = 0; i < arr.length; i++) {
            if (pagesStu + arr[i] <= pages) {
                pagesStu += arr[i];
            } else {
                stu++;
                pagesStu = arr[i];
            }
        }
        return stu;
    }

    private int maxi(int arr[]) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int sum(int arr[]) {
        int s = 0;
        for (int num : arr) {
            s += num;
        }
        return s;
    }
}
