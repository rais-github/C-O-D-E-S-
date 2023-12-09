class knightDialer_memo{
    
    int[][] memo;
    int n;
      final int MOD = (int) 1e9 + 7;
       int[][] jumps = {
           {4, 6},
           {6, 8},
           {7, 9},
           {4, 8},
           {3, 9, 0},
           {},
           {1, 7, 0},
           {2, 6},
           {1, 3},
           {2, 4}
       };
       
       public int knightDialer(int n) {
           this.n=n;
           memo=new int[n+1][10];
           int res=0;
           for(int cell=0;cell<10;cell++)
           {
               res=(res+solve(n-1,cell))%MOD;
           }
           return res;
       }
       private int solve(int remain,int cell)
       {
           if(remain==0) return 1;
           if(memo[remain][cell]!=0) return memo[remain][cell];
           int ans=0;
           for(int nextCell:jumps[cell])
           {
               ans=(ans+solve(remain-1,nextCell))%MOD;
           }
           memo[remain][cell]=ans;
           return ans;
       }
   }
