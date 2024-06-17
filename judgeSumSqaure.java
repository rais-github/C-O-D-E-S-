class Solution {
    public boolean judgeSquareSum(int c) {
        if(c < 3 ) return true;
        long left  =0 , right = (long)Math.sqrt(c);
        while(left <= right)
        {
            long val = (left*left) + (right * right);
            if(val == c) 
            {
                return true;
            }
            else if(val < c)
            {
                left ++;
            }
            else right--;
        }
        return false;
    }
}
