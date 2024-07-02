class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        int len1 = nums1.size(), len2 = nums2.size();
        vector<int> result;
        if (len1 < len2) {
            sort(nums2.begin(), nums2.end()); // nlogn
            for (int i = 0; i < len1; i++) { // m
                if (binarySearch(nums2, nums1[i])) { // logm
                    result.push_back(nums1[i]);
                }
            }
        } else {
            sort(nums1.begin(), nums1.end());
            for (int i = 0; i < len2; i++) {
                if (binarySearch(nums1, nums2[i])) {
                    result.push_back(nums2[i]);
                }
            }
        }
        return result;
    }
private:
    bool binarySearch(vector<int>& nums, int target) {
        int low = 0, high = nums.size() - 1;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (nums[mid] == target) {
                nums.erase(nums.begin() + mid); 
                return true;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
};
