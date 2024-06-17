import java.util.Vector;
class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (n == 1 && m == 1) {
            return 1;
        }
        
        Vector<Integer> cnt = new Vector<>();
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                toggle(grid[i]);
            }
        }
        
        for (int j = 1; j < m; j++) {
            int countOnes = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 1)
                    countOnes++;
            }
            if (countOnes < n - countOnes) { // check that are there more number of ones that is will there be more ones after toggling this coloumn 
                toggle(grid, j, n);
            }
        }
        
        int sum = 0;
        for (int[] arr : grid) {
            int rowSum = 0;
            for (int num : arr) {
                rowSum = (rowSum << 1) + num; 
            }
            sum += rowSum;
        }
        return sum;
    }

    private void toggle(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? 1 : 0; 
        }
    }

    private void toggle(int[][] grid, int col, int n) {
        for (int i = 0; i < n; i++) {
            grid[i][col] = grid[i][col] == 0 ? 1 : 0;
        }
    }
}
