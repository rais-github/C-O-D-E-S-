class Solution {
 public int maxSumAfterPartitioning(int[] arr, int k) {

        var dp = new int[arr.length+1];

        for(var i = arr.length-1; i >= 0; i--){
            dp[i] = helper(arr, k, i, dp);
        }

        return dp[0];
    }

    private int helper(int[] arr, int k, int currentIdx, int[] dp){
        
        var curentMaxEl = arr[currentIdx];
        var max = Integer.MIN_VALUE;
        for(var i = currentIdx; i < Math.min(arr.length, currentIdx+k); i++){ 
            curentMaxEl = Math.max(curentMaxEl, arr[i]);
            max = Math.max(max, curentMaxEl*(i-(currentIdx-1))+dp[i+1]);
        }
        
        return max;
    }
}
