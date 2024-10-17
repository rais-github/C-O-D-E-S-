class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int maxi = -(int)1e8;
        int []dp = new int [n];
        Arrays.fill(dp,1);
        Arrays.sort(words, (x, y) -> {
            if (x.length() != y.length()) {
                return Integer.compare(x.length(), y.length()); 
            } else {
                return x.compareTo(y); 
            }
        });
        
        for(int i = 0 ; i < n ; i++)
        {
            for(int prev=0;prev<i ; prev++)
            {
                if( (words[i].length()==words[prev].length()+1) && isPredecessor(words[i],words[prev]) && dp[prev]+1>dp[i])
                {
                    dp[i]=dp[prev]+1;
                }
            }
            if(dp[i]>maxi) maxi=dp[i];
        }
        return maxi;
    }
    private boolean isPredecessor(String wordA , String wordB)
    {
        int ptrA = 0 , ptrB = 0;
        while(ptrA<wordA.length())
        {
            if(ptrB<wordB.length() && wordA.charAt(ptrA)==wordB.charAt(ptrB))
            {
                ptrA++;
                ptrB++;
            }
            else ptrA++;
        }
        if(ptrA==wordA.length() && ptrB==wordB.length()) return true;
        return false;
    }
}
