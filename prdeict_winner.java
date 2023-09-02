Brute Force
Let's build the search tree first, take nums = [3, 2, 4] for example,

 [3,2,4]
   3/\4---------- 1st player's decision
[2,4] [3,2]
2/ \4  3/ \2----- 2nd player's decision
[4][2] [2][3]

currently 1st with choosable i, j,
        1.if 1st picks nums[i], 2nd can pick either ends of nums[i + 1, j]
            a.if 2nd picks nums[i + 1], 1st can pick either ends of nums[i + 2, j]
            b.if 2nd picks nums[j], 1st can pick either ends of nums[i + 1, j - 1]
            since 2nd plays to maximize his score, 1st can get nums[i] + min(1.a, 1.b)
						
        2.if 1st picks nums[j], 2nd can pick either ends of nums[i, j - 1]
            a.if 2nd picks nums[i], 1st can pick either ends of nums[i + 1, j - 1];
            b.if 2nd picks nums[j - 1], 1st can pick either ends of nums[i, j - 2];
            since 2nd plays to maximize his score, 1st can get nums[j] + min(2.a, 2.b)
        
        since the 1st plays to maximize his score, 1st can get max(nums[i] + min(1.a, 1.b), nums[j] + min(2.a, 2.b));
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        int scoreFirst = predictTheWinnerFrom(nums, 0, nums.length - 1);
        int scoreTotal = getTotalScores(nums);
        
        // Compare final scores of two players.
        return scoreFirst >= scoreTotal - scoreFirst;
    }
    
    private int predictTheWinnerFrom(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return nums[i];
        }
        
        int curScore = Math.max(
            nums[i] + Math.min(
                predictTheWinnerFrom(nums, i + 2, j), 
                predictTheWinnerFrom(nums, i + 1, j - 1)
            ),
            nums[j] + Math.min(
                predictTheWinnerFrom(nums, i, j - 2), 
                predictTheWinnerFrom(nums, i + 1, j - 1)
            )
        );   
        return curScore;
    }
    
    private int getTotalScores (int[] nums) {
        int scoreTotal = 0;
        for (int num : nums) {
            scoreTotal += num;
        }
        
        return scoreTotal;
    }
}
Top-down DP
To overcome overlapping subproblems, we use memoization.

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] memo = buildMemo(nums.length);
        
        int scoreFirst = predictTheWinnerFrom(nums, 0, nums.length - 1, memo);
        
        int scoreTotal = getTotalScores(nums);
        
        return scoreFirst >= scoreTotal - scoreFirst;
    }
    
    private int predictTheWinnerFrom(int[] nums, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }
        
        if (i == j) {
            return nums[i];
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        int curScore = Math.max(
            nums[i] + Math.min(
                predictTheWinnerFrom(nums, i + 2, j, memo), 
                predictTheWinnerFrom(nums, i + 1, j - 1, memo)
            ),
            nums[j] + Math.min(
                predictTheWinnerFrom(nums, i, j - 2, memo), 
                predictTheWinnerFrom(nums, i + 1, j - 1, memo)
            )
        );   
        
        return memo[i][j] = curScore;
    }
    
    private int getTotalScores (int[] nums) {
        int scoreTotal = 0;
        for (int num : nums) {
            scoreTotal += num;
        }
        
        return scoreTotal;
    }
    
    private int[][] buildMemo(int n) {
        int[][] memo = new int[n][n];
        
        for (int[] memoRow : memo)
            Arrays.fill(memoRow, -1);
        return memo;
    }
}
Python

    def PredictTheWinner(self, nums):
        n = len(nums)
        memo = [[-1 for x in range(n)] for y in range(n)]      
        scoreFirst = self.PredictTheWinnerInSituation(nums, 0, n - 1, memo)
        scoreTotal = sum(nums)
        return scoreFirst >= scoreTotal - scoreFirst
    
    def PredictTheWinnerInSituation(self, nums, i, j, memo):
        # Base case.
        if i > j:
            return 0
        if i == j:
            return nums[i]
        if memo[i][j] != -1:
            return memo[i][j]
        # Recursive case.
        curScore = max(nums[i] + min(self.PredictTheWinnerInSituation(nums, i+2, j, memo), self.PredictTheWinnerInSituation(nums, i+1, j-1, memo)), 
                       nums[j] + min(self.PredictTheWinnerInSituation(nums, i, j-2, memo), self.PredictTheWinnerInSituation(nums, i+1, j-1, memo)))
        memo[i][j] = curScore        
        return curScore
