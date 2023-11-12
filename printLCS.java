public class printLCS {
    private String lcs(String s1,String s2)
    {
        StringBuilder sb = new StringBuilder();
        int i=s1.length(),j=s2.length();
        int dp[][]=new int[i][j];
        func(dp,s1,s2);
        while (i>0 && j>0) {
            if(dp[i-1]==dp[j-1])
            {
                sb.append(s1.charAt(i-1));
                i--;j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else j--;
        }
        return sb.reverse().toString();
    }
    private void func(int[][]dp , String s1, String s2)
    {
        for(int i=1;i<=s1.length();i++)
        {
            for(int j=1;j<=s2.length();j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }
}
