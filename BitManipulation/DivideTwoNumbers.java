package BitManipulation;

public class DivideTwoNumbers {

    public int divide(int dividend, int divisor) {

        if (dividend == divisor)
            return 1;

        boolean sign = true;

        if (dividend >= 0 && divisor < 0)
            sign = false;
        if (dividend < 0 && divisor >= 0)
            sign = false;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long ans = 0;

        while (n >= d) {
            int count = 0;

            while (n >= (d << (count + 1))) {
                count++;
            }

            ans += (1L << count);
            n -= (d << count);
        }

        if (!sign)
            ans = -ans;

        // Handle overflow case
        if (ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (ans < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) ans;
    }

    public static void main(String args[]) {

    }
}
