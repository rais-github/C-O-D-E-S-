class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] str = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1; // Initialize the last element of dp array

        for (int i = n - 1; i >= 0; i--) {
            if (str[i] != '0') {
                dp[i] += dp[i + 1]; // Single length partition
            }

            if (i + 1 < n && (str[i] == '1' || (str[i] == '2' && str[i + 1] >= '0' && str[i + 1] <= '6'))) {
                dp[i] += dp[i + 2]; // Double length partition
            }
        }

        return dp[0];
    }
}
