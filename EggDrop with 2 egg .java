class Solution {
    int memo[][]=new int[1001][3];
    public int twoEggDrop(int n) {

        return solve(n, 2);
    }

    private int solve(int n, int e) {
        if (n == 0 || n == 1 || e == 0) return n;
        if (e == 1) return n;
        if(memo[n][e]!=0) return memo[n][e];
        int mn = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int temp = 1 + Math.max(solve(i - 1, e - 1), solve(n - i, e));
            mn = Math.min(mn, temp);
        }
        memo[n][e]=mn;
        return mn;
    }
}
