public class minimumDel2makePalindrome {
    public int minimumDel(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        int lps=lcs(s,rev);
        int len=s.length();
        return len-lps;
    }
    public int lcs(String text1, String text2) {
        int n = text1.length();
        
        int[][] dp = new int[n+1][n+1];
        
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(s1[i-1] == s2[j-1]) { 
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
        
    }
}
