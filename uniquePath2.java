class Solution {
    public int uniquePathsWithObstacles(int[][] oG) {
        if(oG[0][0]==1) return 0;
        oG[0][0]=1;
        int n=oG.length,m=oG[0].length;
        for(int i=1;i<m;i++)
        {
            if(oG[0][i]==1) oG[0][i]=0;
            else oG[0][i]=oG[0][i-1];
        }
          for(int i=1;i<n;i++)
        {
            if(oG[i][0]==1) oG[i][0]=0;
            else oG[i][0]=oG[i-1][0];
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                if(oG[i][j]==1) oG[i][j]=0;
                else oG[i][j]=oG[i-1][j]+oG[i][j-1];
            }
        }
        return oG[n-1][m-1];
    }
}