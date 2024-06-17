class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        if (low < high) {
            int partitionIdx = partition(nums, low, high);
            if (partitionIdx == k)
                return nums[k];
            if (k < partitionIdx) {
                return quickSelect(nums, low, partitionIdx - 1, k);
            } else {
                return quickSelect(nums, partitionIdx + 1, high, k);
            }
        }
        return nums[low];
    }

protected int partition(int[] nums, int low, int high) {
    int pivot = nums[low];
    int i = low + 1, j = high;
    while (i <= j) {
        while (i <= high && nums[i] < pivot) {
            i++;
        }
        while (j >= low && nums[j] > pivot) {
            j--;
        }
        if (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    swap(nums, low, j);
    return j;
}


    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
