package BinarySearch;

//LeetCode 1482
public class MBuquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = mini(bloomDay), high = maxi(bloomDay);
        int ans = high;
        if ((long) m * k > bloomDay.length)
            return -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(mid, bloomDay, m, k)) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean possible(int d, int[] bloomDay, int m, int k) {
        int count = 0;
        int c = 0;

        for (int num : bloomDay) {
            if (num <= d) { // flower is bloomed
                c++;
                if (c == k) {
                    count++;
                    c = 0;
                }
            } else {
                c = 0;
            }
        }
        return count >= m;
    }

    private int mini(int arr[]) {
        int min = arr[0];
        for (int num : arr) {
            min = Math.min(min, num);
        }
        return min;
    }

    private int maxi(int arr[]) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}
