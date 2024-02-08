class Solution {
    private int lowerBound(int []arr,int n,int target){
        int low=0,high=n-1,first=n;
        while(low<=high){
            int mid=(high-low)/2+low;
            if(arr[mid]>=target){
                first=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return first;
    }
    private int upperBound(int []arr,int n,int target){
        int low=0,high=n-1,last=n;
        do{
            int mid=(low+high)/2;
            if(arr[mid]>target){
                last=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }while(low<=high);
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int lb=lowerBound(nums,nums.length,target);
        if(lb==nums.length || target!=nums[lb] ) return new int[]{-1,-1};
        return new int[]{lb,upperBound(nums,nums.length,target)-1};
    }
}
