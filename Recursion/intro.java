package Recursion;

public class intro {

    public static void decrising(int n) {
        if (n == 0)
            return;
        System.out.print(n + " ");
        decrising(n - 1);
    }

    public static void printIncreasing(int n) {
        if (n == 0)
            return;
        printIncreasing(n - 1);

        System.out.print(n + " ");
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        int fn = n * fact(n - 1);
        return fn;
    }

    public static void pdi(int n) {// print decresing increasing
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        pdi(n - 1);
        System.out.print(n + " ");
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1 || x == 0) {
            return x;
        }
        int pnm1 = power(x, n - 1);
        int pn = x * pnm1;
        return pn;
    }

    public static int powLograthmic(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int xpnb2 = powLograthmic(x, n / 2);
        int xn = xpnb2 * xpnb2;
        if (n % 2 == 1) {
            xn = xn * x;
        }
        return xn;
    }

    public static void main(String args[]) {
        int n = 10;
        decrising(n);
        System.out.println();
        printIncreasing(n);
        System.out.println();
        pdi(5);
        System.out.println();
        System.out.println(fact(6));
        System.out.println(power(2, 10));
        System.out.println(powLograthmic(2, 10));
    }
}
