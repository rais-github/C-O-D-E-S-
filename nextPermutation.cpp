class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int breakPoint = -1;
        int n = nums.size();

        // Find the first element from the right that is smaller than its next element
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        // If no such element is found, reverse the whole array
        if (breakPoint == -1) {
            reverse(nums.begin(), nums.end());
            return;
        }

        // Find the smallest element to the right of breakPoint that is greater than nums[breakPoint]
        int i;
        for (i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[breakPoint]) {
                swap(nums[i], nums[breakPoint]);
                break;
            }
        }

        // Reverse the subarray to the right of breakPoint
        reverse(nums.begin() + breakPoint + 1, nums.end());
        return;
    }
};
