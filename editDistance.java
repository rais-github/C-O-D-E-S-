class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2))
            return 0;

        int n = word1.length(), m = word2.length();
        int[] prev = new int[m + 1];

        // Base case: converting word1 to an empty word2
        for (int i = 0; i <= m; i++) {
            prev[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i; // If word2 is empty, remove all characters from word1

            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    int replace = prev[j - 1];
                    int remove = prev[j];
                    int insert = curr[j - 1];
                    curr[j] = 1 + Math.min(replace, Math.min(remove, insert));
                }
            }

            // Move to the next row by setting prev to curr
            prev = curr;
        }

        return prev[m];
    }

    private int tabulation(String word1, String word2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        // Base case: If one string is empty, you need to insert all characters of the
        // other string
        for (int i = 0; i <= n; i++)
            dp[i][0] = i; // If word2 is empty, remove all characters from word1
        for (int j = 0; j <= m; j++)
            dp[0][j] = j; // If word1 is empty, insert all characters from word2

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // If the characters are the same, no operation is needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the characters are different, consider the three operations
                    int replace = dp[i - 1][j - 1];
                    int remove = dp[i - 1][j];
                    int insert = dp[i][j - 1];
                    dp[i][j] = 1 + Math.min(replace, Math.min(remove, insert));
                }
            }
        }

        // The answer is in dp[n][m], the minimum number of operations to transform
        // word1 into word2
        return dp[n][m];
    }

    private int memoization(Integer[][] memo, char[] s1, char[] s2, int i, int j, int n, int m) {
        // Base case: if we reach the end of either string
        if (i == n)
            return m - j; // Insert remaining characters from s2
        if (j == m)
            return n - i; // Remove remaining characters from s1
        if (memo[i][j] != null)
            return memo[i][j];
        // If characters match, move to the next pair
        if (s1[i] == s2[j]) {
            return memo[i][j] = memoization(memo, s1, s2, i + 1, j + 1, n, m);
        } else {
            // Try all three operations:
            // 1. Replace (consider replacing s1[i] with s2[j])

            int replace = memoization(memo, s1, s2, i + 1, j + 1, n, m);

            // 2. Remove (remove current character of s1)
            int remove = memoization(memo, s1, s2, i + 1, j, n, m);

            // 3. Insert (insert s2[j] into s1)
            int insert = memoization(memo, s1, s2, i, j + 1, n, m);

            // Return the minimum number of operations + 1 for the current operation
            return memo[i][j] = 1 + Math.min(replace, Math.min(remove, insert));
        }
    }
}
