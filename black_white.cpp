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
