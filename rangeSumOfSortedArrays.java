class Solution {
    final int MOD = (int)1e9+7;
    public int rangeSum(int[] nums, int n, int left, int right) {
       int sumArray[] = new int[n * (n + 1) / 2];
        int sum = 0;

        // Compute prefix sums
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = (prefix[i] + nums[i]) % MOD;
        }

        // Create subarray sums using prefix sums
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sumArray[k++] = (prefix[j + 1] - prefix[i]) % MOD;
            }
        }

        // Sort the subarray sums
        Arrays.sort(sumArray);

        // Compute the range sum
        for (int i = left - 1; i < right; i++) {
            sum = (sum + sumArray[i]) % MOD;
        }

        return sum;
    }
}
