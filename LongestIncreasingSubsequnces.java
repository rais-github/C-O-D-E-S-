class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];//i+1
        for (int i = n - 1; i >= 0; i--) {
            int curr[] = new int [n+1];
            for (int j = i - 1; j >= -1; j--) {
                curr[j+1]=next[j+1];
                if (j == -1 || nums[i] > nums[j]) {
                    curr[j + 1] = Math.max(curr[j + 1], 1 +next[i + 1]);
                } 
            }
            next=curr;
        }
        return next[0];
    }

    private int solve(Integer memo[][], int[] nums, int n, int idx, int prevIdx) {
        if (idx == n) {
            return 0; // Base case: If we have processed all elements, return 0
        }
        if (memo[idx][prevIdx + 1] != null)
            return memo[idx][prevIdx + 1];
        int notPick = solve(memo, nums, n, idx + 1, prevIdx);

        int pick = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            pick = 1 + solve(memo, nums, n, idx + 1, idx);
        }

        return memo[idx][prevIdx + 1] = Math.max(pick, notPick);
    }
}
