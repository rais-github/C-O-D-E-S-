  class Solution {
public:
    int minDifference(vector<int>& nums) {
        // The intution is to make elements close to each other
        // ex: 2 , 3 , 4  diff = 2 (4-2) but if we try to make
        // 2 close to four or four close to 2 we will eventually
        // get close to minDiff
        // also here at most 3 moves are allowed hence if array
        // size is less than equal to 4 return 0;

        if (nums.size() <= 4)
            return 0;

        int n = nums.size();
        sort(nums.begin(), nums.end());
        // Possible scenarios to minimize the difference
        int option1 = nums[n - 1] - nums[3]; // Remove the 3 smallest elements
        int option2 = nums[n - 2] - nums[2]; // Remove 2 smallest and 1 largest
        int option3 = nums[n - 3] - nums[1]; // Remove 1 smallest and 2 largest
        int option4 = nums[n - 4] - nums[0]; // Remove the 3 largest elements
        return min({option1, option2, option3, option4});
    }
};
