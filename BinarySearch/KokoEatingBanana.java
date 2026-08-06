package BinarySearch;

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Max(piles);
        int ans = Max(piles);
        while (l <= r) {
            int mid = (l + r) / 2;
            long t = time(mid, piles);
            if (t <= h) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private long time(int n, int[] piles) {
        long t = 0;
        for (int num : piles) {
            t += num / n;
            if (num % n != 0)
                t++;
        }
        return t;
    }

    private int Max(int arr[]) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}
