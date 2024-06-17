
class Solution {
    public int reversePairs(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        return mergeSort(nums, 0, nums.length - 1, temp);
    }

    private int mergeSort(int nums[], int low, int high, List<Integer> temp) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (high - low) / 2 + low;
        cnt += mergeSort(nums, low, mid, temp);
        cnt += mergeSort(nums, mid + 1, high, temp);
        cnt += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high, temp);
        return cnt;
    }

    protected int countPairs(int nums[], int low, int mid, int high) {
        int cnt = 0;
        int j = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }
            cnt += (j - (mid + 1));
        }

        return cnt;
    }

    private void merge(int nums[], int low, int mid, int high, List<Integer> temp) {
        temp.clear();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) {
            temp.add(nums[left++]);
        }

        while (right <= high) {
            temp.add(nums[right++]);
        }

        for (int i = 0; i < temp.size(); i++) {
            nums[low + i] = temp.get(i);
        }
    }
}
