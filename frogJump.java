import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
       

         int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i=1;i<n;i++){
                int jumpOne = dp[i-1]+Math.abs(heights[i]-heights[i-1]);
                int jumpTwo=Integer.MAX_VALUE;
                if(i>1){
                     jumpTwo = dp[i-2]+Math.abs(heights[i]-heights[i-2]);
                }
                dp[i]=Math.min(jumpOne,jumpTwo);
        }

        return dp[n-1];
    }

}
