public class minimum_InsandDel_toconvertA2B {
    public int[] lcs(String a , String b)
    {
        int n =a.length(),m=b.length();
        int [][]dp=new int[n+1][m+1];
        char s[]=a.toCharArray();
        char s2[]=b.toCharArray();
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(dp[i-1]==dp[j-1])
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j]);
                }
            }
        }
        int []ans={n-dp[n][m],m-dp[n][m]};
        return ans;
    }
}
