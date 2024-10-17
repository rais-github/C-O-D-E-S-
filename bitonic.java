  int[]dp=new int[n];
        int[]dpRev=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(dpRev,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j] && dpRev[i]<dpRev[j]+1){
                    dpRev[i]=dpRev[j]+1;
                }
            }
        }
        int max=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]!=1 && dpRev[i]!=1)
            max=Math.max(max,dp[i]+dpRev[i]-1);
        }
        return max;
