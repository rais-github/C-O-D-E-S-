public class LCsubstring {
    private int common(String s1,String s2)
    {
        int l1=s1.length();
        int l2=s2.length();
        int dp[][]=new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l2;j++)
            {
                dp[i][j]=dp[i-1][j-1]+1;
            }
        }
        return dp[l1][l2];
    }
}
