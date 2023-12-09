class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        
        // Find the maximum value in the input array
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] freq = new int[maxVal + 1];
        
        // Calculate the frequency of each element in the array
        for (int num : nums) {
            freq[num] += num; // Store the sum of each element's frequency
        }

        // Initialize variables to store the results for the previous and current steps
        int prevMax = 0; // Represents dp[i-2]
        int currMax = freq[1]; // Represents dp[i-1] for the first element

        // Iterate starting from the second element (i=2) up to the maximum value
        for (int i = 2; i <= maxVal; i++) {
            int temp = currMax; // Store the current maximum for later use
            currMax = Math.max(currMax, prevMax + freq[i]);
            prevMax = temp; // Update prevMax for the next iteration
            // Max(exclude current, take current + currentIdx-2) as adjacent elements aren't allowed
        }

        // Return the maximum points for collecting the max element in nums
        return currMax; // We are not returning the last element of the array but the maximum points accumulated
    }
}
