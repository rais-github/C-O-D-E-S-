class Solution{

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // Create a 2D dp array with size (N+1) x (sum+1)
        boolean [][] dp = new boolean [N+1][sum+1];
        
        // Base case: sum = 0 is always possible with an empty subset
        dp[0][0] = true;
        
        // When the size of the subset is >=1, sum = 0 is possible with an empty subset
        for(int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        
        // When the size of the subset is 0 but sum is expected (non-zero sum), it's impossible
        for(int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }
        
        // Fill the dp table
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= sum; j++) {
                // If the current element can be included in the subset (arr[i-1] <= j)
                if(arr[i-1] <= j) {
                    // Either we include it or we don't include it
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else {
                    // We cannot include the current element, so we take the result from dp[i-1][j]
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[N][sum];
    } 
}
