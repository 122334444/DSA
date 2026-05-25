package Greedy;

public class minimumNumberOfCoins {

    public static int minCoins(int coins[], int v) {
        int n = coins.length;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (v >= coins[i]) {
                int a = v / coins[i];
                count += a;
                v = v - a * coins[i];
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 1000 };
        int amount = 49;
        System.out.println(minCoins(coins, amount));
    }
}
