class Solution {
    final static int  MOD=1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int []dp=new int [high+1];
        dp[0]=1;
        for(int end=1;end<=high;end++){
            if(end>=one){
                dp[end]=(dp[end]+dp[end-one])%MOD;
            }
            if(end>=zero){
                dp[end]=(dp[end]+dp[end-zero])%MOD;
            }
        }

        int res=0;
        for(int range=low;range<=high;range++){
            res=(res+dp[range])%MOD;
        }
        return res;
    }
}
