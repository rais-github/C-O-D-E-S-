public class Solution {
    public static boolean isSubsetPresent(int n, int k,int []a) {
        // Write your code here
        return helper(n,k,0,0,a);
    }
    private static boolean helper(int n , int sum, int idx , int tempSum , int []nums)
    {
        if(sum<tempSum) return false;
        if(idx==n)
        {
            if(tempSum==sum) return true;
            return false;
        }

        if(helper(n,sum,idx+1,tempSum+nums[idx],nums) || helper(n,sum,idx+1,tempSum,nums)) return true;
        return false;
    }
}
