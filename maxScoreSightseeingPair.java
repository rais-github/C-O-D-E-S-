class Solution {
    public int maxScoreSightseeingPair(int[] prices) {
        int n = prices.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill the leftMax array
        leftMax[0] = prices[0] + 0;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], prices[i] + i);
        }

        // Fill the rightMax array
        rightMax[n - 1] = prices[n - 1] - (n - 1);
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], prices[j] - j);
        }

        // Calculate the maximum score
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            maxScore = Math.max(maxScore, leftMax[i] + rightMax[i + 1]);
        }

        return maxScore;
    }
}
