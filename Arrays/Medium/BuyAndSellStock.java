package Arrays.Medium;

public class BuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int maxProf = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            maxProf = Math.max(maxProf, prices[i] - min);
        }
        return maxProf;
    }

    public static void main(String args[]) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
}
