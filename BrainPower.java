import java.util.Arrays;

class Solution {
    public long mostPoints(int[][] questions) {
    int n = questions.length;
    long[] dp = new long[n + 1];
    
    for (int i = n - 1; i >= 0; i--) {
        long take = questions[i][0] + (i + questions[i][1] < n ? dp[i + questions[i][1] + 1] : 0);
        long notTake = dp[i + 1];

        long maxPoints = Math.max(take, notTake);
        dp[i] = maxPoints;
    }

    return dp[0];
}


    private long solve(int idx, int[][] questions, int n, long[] memo) {
        if (idx >= n) return 0;

        if (memo[idx] != -1) {
            return memo[idx];
        }

        long take = questions[idx][0] + solve(idx + 1 + questions[idx][1], questions, n, memo);
        long notTake = solve(idx + 1, questions, n, memo);

        long maxPoints = Math.max(take, notTake);
        memo[idx] = maxPoints;

        return maxPoints;
    }
}
