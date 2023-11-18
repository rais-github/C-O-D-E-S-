public class shortest_common_superSequence {
    public static int lcs(String[] args) {
        String s1="Geek";
        String s2="Eve";
        int n=s1.length(),m=s2.length();
        char []st1=s1.toCharArray();
        char []st2=s2.toCharArray();
        int [][]dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(st1[i-1] == st2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return m+n-dp[n][m];
    }
}
