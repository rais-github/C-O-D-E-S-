class futureDp{
    public static void main(String []args)
    {
        int []wine = {2,3,5,1,4};
        System.out.println(maxProfit(wine));
    }
    private static int maxProfit(int[]wine)
    {
        int [][]dp = new int[wine.length][wine.length];
        int year = wine.length;
        for(int i=  0 ; i< dp.length ; i++)
        {
            dp[i][i]= wine[i]*year;
        }
        year--;
        for(int gap =1 ; gap<dp.length ;gap++)
        {
            for(int j = gap ; j<dp.length ; j++)
            {
                int i = j -gap;
                int fs = wine[i] * year + dp[i-1][j];
                int ls = wine[j] * year + dp[i][j-1];
                dp[i][j]=Math.max(fs,ls);
            }
            year--;
        }
        return dp[0][dp[0].length-1];
    }
}
