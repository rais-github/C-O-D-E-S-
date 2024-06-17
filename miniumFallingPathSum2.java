class Solution {
    int[][] memo; // Declare a 2D array to store memoization values

    public int minFallingPathSum(int[][] grid) {
        int rows = grid.length; // Get the number of rows in the grid
        int cols = grid[0].length; // Get the number of columns in the grid
        if(rows == 1 && cols == 1) // Check if there's only one cell in the grid
            return grid[0][0]; // Return its value
        memo = new int[rows][cols]; // Initialize the memoization array with grid dimensions
        for (int[] row : memo) { // Loop through each row in the memoization array
            Arrays.fill(row, -1); // Initialize each element with -1 for uncomputed values
        }
        int minFallingSum = Integer.MAX_VALUE; // Initialize the minimum falling path sum with the maximum integer value
        for (int col = 0; col < cols; col++) { // Loop through each column in the grid
            int tempSum = helper(0, col, grid); // Calculate the falling path sum starting from the current column
            minFallingSum = Math.min(minFallingSum, tempSum); // Update the minimum falling path sum
        }
        return minFallingSum; // Return the minimum falling path sum
    }

    private int helper(int r, int c, int[][] grid) {
        if (r == grid.length - 1) { // Check if we're at the last row of the grid
            return grid[r][c]; // Return the value of the current cell
        }
        if (memo[r][c] != -1) // Check if the memoization value for the current cell is already computed
            return memo[r][c]; // Return the memoized value
        int miniCurrFallSum = Integer.MAX_VALUE; // Initialize the minimum falling path sum for the current cell
        for (int col = 0; col < grid[0].length; col++) { // Loop through each column in the grid
            if (col != c) { // Skip the last chosen coloumn 
                int currColFallingSum = helper(r + 1, col, grid); // Calculate the falling path sum for the next row and column
                miniCurrFallSum = Math.min(miniCurrFallSum, currColFallingSum); // Update the minimum falling path sum
            }
        }

        return memo[r][c] = grid[r][c] + miniCurrFallSum; // Memoize and return the minimum falling path sum for the current cell
    }
}
