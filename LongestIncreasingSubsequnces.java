class Solution {
    Integer memo[][];
    public int lengthOfLIS(int[] nums) {
        memo = new Integer[nums.length][nums.length];
        return solve(0, -1, nums);
    }
    
    private int solve(int idx, int prevInd, int[] nums) {
        if (idx == nums.length) return 0;
        if (memo[idx][prevInd + 1] != null) return memo[idx][prevInd + 1];
        
        int len = solve(idx + 1, prevInd, nums);
        if (prevInd == -1 || nums[idx] > nums[prevInd]) {
            len = Math.max(len, 1 + solve(idx + 1, idx, nums));
        }
        
        return memo[idx][prevInd + 1] = len;
    }
}
