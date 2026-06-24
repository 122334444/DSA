package DP.Stocks;

public class buyAndSellStock3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return fxn(0, 1, 2, prices, dp);
    }

    private int fxn(int idx, int buy, int cap, int prices[], int dp[][][]) {
        if (idx == prices.length)
            return 0;
        if (cap == 0)
            return 0;

        if (dp[idx][buy][cap] != -1) {
            return dp[idx][buy][cap];
        }

        if (buy == 1) {
            dp[idx][buy][cap] = Math.max(
                    -prices[idx] + fxn(idx + 1, 0, cap, prices, dp),
                    fxn(idx + 1, 1, cap, prices, dp));
        } else {// shell
            dp[idx][buy][cap] = Math.max(
                    prices[idx] + fxn(idx + 1, 1, cap - 1, prices, dp), // sell
                    fxn(idx + 1, 0, cap, prices, dp)// skip
            );
        }
        return dp[idx][buy][cap];
    }

}
