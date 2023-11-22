// in order to find lps u need to take the given strign a have duplicated reverse string and find the lcs which would be our required longest palindromic subsequnce

class Solution {
    public String lps_wrong(String s) {
        StringBuilder rev = new StringBuilder(s);
        String sec = rev.reverse().toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == sec.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        rev = new StringBuilder();
        int i = n, j = n;
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == sec.charAt(j - 1)) {
                rev.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return rev.reverse().toString();
    }
}
