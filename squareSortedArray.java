class Solution {
    private int sqr(int val){
        return val*val;
    }
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int low = 0, high = nums.length-1;
        int[] result = new int[n];
        int ptr = nums.length-1;
        while (low <= high) {
            if (Math.abs(nums[low]) < Math.abs(nums[high])) {
                result[ptr] = sqr(nums[high]);
                high--;
            } else {
                result[ptr] = sqr(nums[low]);
                low++;
            }
            ptr--;
        }
        return result;
    }
}
