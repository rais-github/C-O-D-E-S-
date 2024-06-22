class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            nums[i] = ((nums[i]&1)==0)?0:1;
        }
        return subarraySum(nums,k);
    }
    private int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int cnt = 0, prefixSum = 0;
        for (int ele : nums) {
            prefixSum += ele;
            if (map.containsKey(prefixSum - k)) {
                cnt = cnt + map.get(prefixSum - k);
            }
            if (map.containsKey(prefixSum)) {
                map.put(prefixSum, map.get(prefixSum) + 1);
            } else
                map.put(prefixSum, 1);
        }
        return cnt;
    }
}
