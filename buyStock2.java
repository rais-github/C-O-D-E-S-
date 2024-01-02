class Solution {
    public int maxProfit(int[] prices) {
        int totalDays = prices.length;
        int[][] dp = new int[totalDays + 1][2];
        dp[totalDays][0] = dp[totalDays][1] = 0;

        for (int idx = totalDays - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                int profit = 0;

                if (buy == 1) {
                    profit = Math.max(-prices[idx] + dp[idx + 1][0], 0 + dp[idx + 1][1]);
                } else {
                    profit = Math.max(prices[idx] + dp[idx + 1][1], 0 + dp[idx + 1][0]);
                }

                dp[idx][buy] = profit;
            }
        }
        return dp[0][1];
    }
}
