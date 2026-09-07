package Recursion;

public class powerN {

    public static double power(int x, int n) {
        double ans = 1.0;
        long N = n;
        if (N < 0)
            N = -1 * N;

        while (N > 0) {
            if (N % 2 != 0) {
                ans = ans * x;
                N = N - 1;
            } else {
                x = x * x;
                N = N / 2;
            }
        }
        if (n < 0)
            ans = (double) (1.0) / (double) (ans);
        return ans;
    }

    public static void main(String args[]) {
        int x = 5;
        int n = -4;
        System.out.println(power(x, n));
    }
}
