class Solution {
    public int minSwaps(int[] nums) {
        int swapCount = 0, minSwap = Integer.MAX_VALUE, groupSize = 0, i = 0, j = 0;
        int n = nums.length;
        int[] arr = new int[2 * n];
        
        // Create the doubled array and count the number of 1's (groupSize)
        for (int k = 0; k < n; k++) {
            arr[k + n] = nums[k];
            arr[k] = nums[k];
            if (nums[k] == 1) groupSize++;
        }
        
        // Initialize the first window
        for (j = 0; j < groupSize; j++) {
            if (arr[j] == 0) swapCount++;
        }
        
        minSwap = swapCount;
        
        // Sliding window over the array to find the minimum swaps
        while (j < 2 * n) {
            if (arr[j] == 0) swapCount++;
            if (arr[i] == 0) swapCount--;
            
            minSwap = Math.min(minSwap, swapCount);
            i++;
            j++;
        }
        
        return minSwap;
    }
}
