class Solution {
    public int maxCoins(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int num:nums) arr.add(num);
        arr.add(0,1);arr.add(1);
        int N = arr.size();
        int[][] dp = new int[N][N];

        for (int i = N - 1; i >= 1; i--) {
            for (int j = i + 1; j < N; j++) {
                int minOperations = Integer.MIN_VALUE;

                for (int k = i; k <= j - 1; k++) {
                    int operations = dp[i][k] + dp[k + 1][j] + arr.get(i-1) * arr.get(k) * arr.get(j);
                    minOperations = Math.max(minOperations, operations);
                }

                dp[i][j] = minOperations;
            }
        }
        return dp[1][N - 1];
    }
}
