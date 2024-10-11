class Solution {
    public int minimumEnergy(int arr[], int N) {
        if (N == 1) return 0;  // If there's only one step, no energy needed
        if (N == 2) return Math.abs(arr[1] - arr[0]);  // For two steps, it's the direct difference

        int dp[] = new int[N];  // DP array to store minimum energy from each step
        dp[N - 1] = 0;  // No energy is needed at the last step
        
        // Fill the DP array from the second-to-last step to the first
        for (int i = N - 2; i >= 0; i--) {
            // Calculate the minimum energy for one-step jump
            int oneStep = Math.abs(arr[i + 1] - arr[i]) + dp[i + 1];
            
            // Calculate the minimum energy for two-step jump, if possible
            int twoStep = Integer.MAX_VALUE;
            if (i + 2 < N) {
                twoStep = Math.abs(arr[i + 2] - arr[i]) + dp[i + 2];
            }
            
            // Choose the minimum of both options
            dp[i] = Math.min(oneStep, twoStep);
        }

        return dp[0];  // The answer will be stored at dp[0] (starting from the first step)
    }
}
