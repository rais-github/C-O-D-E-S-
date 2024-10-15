class Solution {
    public int numDistinct(String s, String t) {
    int n = s.length(), m = t.length();
    int[] prev = new int[m + 1];

    // Base case: An empty t can always match any prefix of s
    prev[0] = 1;

    for (int i = 1; i <= n; i++) {
        int[] curr = new int[m + 1];  // Create a fresh array for the current row
        curr[0] = 1;  // An empty t can always match any prefix of s
        for (int j = 1; j <= m; j++) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                // dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
                curr[j] = prev[j - 1] + prev[j];
            } else {
                // dp[i][j] = dp[i-1][j]
                curr[j] = prev[j];
            }
        }
        prev = curr;  // Move to the next row
    }

    return prev[m];
}


    private int tabulation(String s, String t, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1; // empty t can be matched to any of s prefix
        for (int j = 0; j <= m; j++)
            dp[0][j] = 0; // non-empty t cannot be matched to empty s
        dp[0][0] = 1; // both empty only one way
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }

    private int memoization(int n, int m, String s, String t, Integer[][] memo) {
        // Base cases
        if (m == 0) {
            return 1; // Successfully matched all characters of t
        }
        if (n == 0) {
            return 0; // Exhausted s, but t is not fully matched
        }
        if (memo[n - 1][m - 1] != null)
            return memo[n - 1][m - 1];

        char ch2 = t.charAt(m - 1);
        char ch1 = s.charAt(n - 1);

        if (ch1 == ch2) {
            // Two choices: match this character or skip it
            return memo[n - 1][m - 1] = memoization(n - 1, m - 1, s, t, memo) + memoization(n - 1, m, s, t, memo);
        }

        // Otherwise, skip the current character of s
        return memo[n - 1][m - 1] = memoization(n - 1, m, s, t, memo);
    }
}
