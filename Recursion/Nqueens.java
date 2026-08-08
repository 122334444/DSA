package Recursion;

public class Nqueens {

    public static int countWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }

        int way1 = countWays(i + 1, j, n, m);
        int way2 = countWays(i, j + 1, n, m);
        return way1 + way2;
    }

    public static void main(String args[]) {
        int n = 4;
        int m = 4;

        System.out.println(countWays(0, 0, n, m));
    }
}
