class Solution {
    public int findClosestNumber(int[] nums) {
        int closer=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                if(nums[i]<=closer){
                    closer=nums[i];
                    ans=nums[i];
                }
            }else{
                if((0-nums[i])<closer){
                    closer=0-nums[i];
                    ans=nums[i];
                }
            }
        }
        return ans;
    }
}
