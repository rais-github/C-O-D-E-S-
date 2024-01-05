import java.util.Arrays;

class Solution {
    private int[][] memo;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][3];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return f(0, 0, prices);
    }

    private int f(int ind, int state, int[] prices) {
        if (ind >= prices.length)
            return 0;

        if (memo[ind][state] != -1) {
            return memo[ind][state];
        }

        if (state == 0) {
            memo[ind][state] = Math.max(-prices[ind] + f(ind + 1, 1, prices), f(ind + 1, 0, prices));
        } else if (state == 1) {
            memo[ind][state] = Math.max(prices[ind] + f(ind + 2, 0, prices), f(ind + 1, 1, prices));
        } else {
            memo[ind][state] = Math.max(f(ind + 1, 0, prices), f(ind + 1, 2, prices));
        }

        return memo[ind][state];
    }
}
