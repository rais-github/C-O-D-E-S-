class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int result = 0;
        do {
            int mid = (high - low) / 2 + low;
            if (isPossiblePartitioning(nums, mid, k)) {
                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1;
            }
        } while (low <= high);

        return result;
    }

    private boolean isPossiblePartitioning(int[] nums, int sum, int k) {
        int partitions = 1;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            if (currentSum > sum) {
                partitions++;
                currentSum = num;
            }
        }

        return partitions <= k;
    }
}
