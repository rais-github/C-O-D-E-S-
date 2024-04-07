import java.util.*;
public class Solution {
    public static int minimizeCost(int n, int k, int[] heights) {
        int[] dp = new int[n];
        
        // Initialize dp array with maximum possible values
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // Base case: no cost to reach the first element
        dp[0] = 0;
        
        // Iterate through each position
        for (int i = 0; i < n; i++) {
            // For each position, try jumping to the next k positions
            for (int j = 1; j <= k && i + j < n; j++) {
                // Update the minimum cost to reach position i+j
                dp[i + j] = Math.min(dp[i + j], dp[i] + Math.abs(heights[i] - heights[i + j]));
            }
        }
        
        // Return the cost to reach the last element
        return dp[n - 1];
    }
}
