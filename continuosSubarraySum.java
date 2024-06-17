    class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n<2) return false;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum = 0;
        for(int i = 0; i<n; i++)
        {
            sum = sum + nums[i];
            sum = sum % k ;
            if(i >=1 && sum == 0 )
            {
                return true;
            }
             if(map.get(sum)!=null && i-map.get(sum)>1)
            {
                return true;
            }
            if(map.get(sum)==null){
                map.put(sum,i);
            }
        }
        return false;
    }
}
