class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {// cap of 0 is zero hence ignore
                    int profit = 0;
                    if (buy == 1) {
                        profit = Math.max(-prices[idx] + dp[idx + 1][0][cap], dp[idx + 1][1][cap]);
                    } else {
                        profit = Math.max(prices[idx] + dp[idx + 1][1][cap - 1], dp[idx + 1][0][cap]);
                    }
                    dp[idx][buy][cap] = profit;
                }
            }
        }
        
        return dp[0][1][2]; 
    }
}
