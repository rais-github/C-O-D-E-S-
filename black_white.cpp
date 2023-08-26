// O(1)
// class BlackAndWhite
// {
//     static final long MOD=1000000007;
//     //Function to find out the number of ways we can place a black and a 
//     //white Knight on this chessboard such that they cannot attack each other.
//     static long numOfWays(int n, int m)
//     {
//         // add your code here
        
//         long total=((m*n)%MOD * (m*n-1)%MOD)%MOD;
//         if(n>=1 && m >=2)
//         {
//             total-=4*(n-1)*(m-2);
//         }
//          if(n>=2 && m >=1)
//         {
//             total-=4*(n-2)*(m-1);
//         }
//         return total;
//     }
// }
long long numOfWays(int n, int m)

{

    // write code here

    long long mod=1e9+7;

    vector<int>dx={-1,-2,2,1,1,2,-2,-1};

    vector<int>dy={2,1,1,2,-2,-1,-1,-2};

 

     long long ans=0;

    for(int i=0;i<n;i++){

        for(int j=0;j<m;j++){

            long long store=0;

            for(int k=0;k<8;k++){

                 int r=i+dx[k];

                 int c=j+dy[k];

                 if(r<n and c<m and r>=0 and c>=0){

                     

                     store++;

                 }

            }

          ans+=((n*m)-store-1);

          ans%=mod;

            

          

            

        }

    }

  

   

   

    return ans;

}
