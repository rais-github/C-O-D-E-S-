class Solution {
    public int minCut(String s) {
        int[][] memo = new int[s.length()][s.length()];
        // Initialize memoization array with -1
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return solve(s, 0, s.length() - 1, memo);
    }

    private int solve(String s, int i, int j, int[][] memo) {
        if (i >= j || isPalindrome(s, i, j)) return 0;

        // Check if the result is already memoized
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int mn = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = 1 + solve(s, i, k, memo) + solve(s, k + 1, j, memo);
            if (mn > temp) {
                mn = temp;
            }
        }

        // Memoize the result
        memo[i][j] = mn;
        return mn;
    }

    protected boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
