    class Solution {
    public int minimizeCost(int k, int arr[]) {
        int N = arr.length;
        if (N == 1) return 0;  // If there's only one step, no energy needed
        if (N == 2) return Math.abs(arr[1] - arr[0]);  // For two steps, it's the direct difference
    
        int dp[] = new int[N];  // DP array to store minimum energy from each step
        dp[0] = 0;  // No energy is needed at the first step
        // Fill the DP array from the first step to the last
        for (int i = 1; i < N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int cost = Math.abs(arr[i] - arr[i - j]) + dp[i - j];
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }

        return dp[N - 1];  // Return the minimum cost to reach the last step
    }
}
