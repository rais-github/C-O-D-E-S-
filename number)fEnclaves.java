class Pair{
    int row,col;
    Pair(int first,int second){
        this.row=first;
        this.col=second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int [][]vis = new int [n][m];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int j=0;j<m;j++){
            if(grid[0][j]==1){
                q.add(new Pair(0,j));
                vis[0][j]=1;
            }
            if(grid[n-1][j]==1){
                q.add(new Pair(n-1,j));
                vis[n-1][j]=1;
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                q.add(new Pair(i,0));
                vis[i][0]=1;
            }
            if(grid[i][m-1]==1){
                q.add(new Pair(i,m-1));
                vis[i][m-1]=1;
            }
        }

        int dRow[]={-1,0,1,0};
        int dCol[]={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            q.remove();
            for(int i=0;i<4;i++){
                int newRow=r+dRow[i];
                int newCol=c+dCol[i];
                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && vis[newRow][newCol]==0 && grid[newRow][newCol]==1){
                    q.add(new Pair(newRow,newCol));
                    vis[newRow][newCol]=1;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
