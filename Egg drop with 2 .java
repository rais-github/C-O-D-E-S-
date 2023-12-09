   class Solution {
        public int twoEggDrop(int n) {
          return solve(n,2);
        }
     private int solve(int n, int e)
     {
       if(e==1 || e==0 || n==1 || n==0) return n;
       int mn=Integer.MAX_VALUE;
       for(int f=1;f<=n;f++){
         int temp = 1+Math.max(solve(i-1,e-1),solve(n-i,e));
         mn = Math.min(mn,temp);
       }
       return mn;
   }
