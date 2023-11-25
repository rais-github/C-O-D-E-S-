public class LRepeatingS {
    public int lrs(String s)
    {
        int n=s.length();
        char []s1=s.toCharArray();
        char []s2=s.toCharArray();

        int[][]dp=new int[n+1][1+n];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1[i-1]==s2[j-1] && i!=j)
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}
