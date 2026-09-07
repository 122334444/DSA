package BinarySearch;

public class SquareRootOfNumber {

    public static long sqRoot(long n) {
        long l = 1, r = n;
        while (l <= r) {
            long mid = (l + r) / 2;
            long val = mid * mid;
            if (val <= n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

}
