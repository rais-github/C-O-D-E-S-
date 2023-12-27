class Solution {
    public int cherryPickup(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        
        // Recursion
        int resultRecursion = cherryPickupRecursive(grid, 0, 0, col - 1);
        
        // Memoization
        Integer[][][] memo = new Integer[row][col][col];
        int resultMemoization = cherryPickupMemoization(grid, 0, 0, col - 1, memo);
        
        // Tabulation
        int[][][] dp = new int[row][col][col];
        int resultTabulation = cherryPickupTabulation(grid, dp);

        return Math.max(Math.max(resultRecursion, resultMemoization), resultTabulation);
    }

    // Recursive
    private int cherryPickupRecursive(int[][] grid, int r, int c1, int c2) {
        // Base case: if out of bounds
        if (c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length)
            return Integer.MIN_VALUE;

        // Base case: if at the bottom row
        if (r == grid.length - 1) {
            if (c1 == c2)
                return grid[r][c1];
            return grid[r][c1] + grid[r][c2];
        }

        int mx = Integer.MIN_VALUE;

        for (int robo1 = -1; robo1 < 2; robo1++) {
            for (int robo2 = -1; robo2 < 2; robo2++) {
                if (c1 == c2) {
                    mx = Math.max(mx, grid[r][c2] + cherryPickupRecursive(grid, r + 1, c1 + robo1, c2 + robo2));
                } else {
                    mx = Math.max(mx, grid[r][c1] + grid[r][c2] + cherryPickupRecursive(grid, r + 1, c1 + robo1, c2 + robo2));
                }
            }
        }
        return mx;
    }

    // Memoization
    private int cherryPickupMemoization(int[][] grid, int r, int c1, int c2, Integer[][][] memo) {
        // Base case: if out of bounds
        if (c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length)
            return Integer.MIN_VALUE;

        // Base case: if at the bottom row
        if (r == grid.length - 1) {
            if (c1 == c2)
                return grid[r][c1];
            return grid[r][c1] + grid[r][c2];
        }

        if (memo[r][c1][c2] != null)
            return memo[r][c1][c2];

        int mx = Integer.MIN_VALUE;

        for (int robo1 = -1; robo1 < 2; robo1++) {
            for (int robo2 = -1; robo2 < 2; robo2++) {
                if (c1 == c2) {
                    mx = Math.max(mx, grid[r][c2] + cherryPickupMemoization(grid, r + 1, c1 + robo1, c2 + robo2, memo));
                } else {
                    mx = Math.max(mx, grid[r][c1] + grid[r][c2] + cherryPickupMemoization(grid, r + 1, c1 + robo1, c2 + robo2, memo));
                }
            }
        }
        return memo[r][c1][c2] = mx;
    }

    // Tabulation
    private int cherryPickupTabulation(int[][] grid, int[][][] dp) {
        int row = grid.length, col = grid[0].length;

        // Base case: initialize the bottom row of dp array
        for (int col1 = 0; col1 < col; col1++) {
            for (int col2 = 0; col2 < col; col2++) {
                if (col1 == col2) {
                    dp[row - 1][col1][col2] = grid[row - 1][col1];
                } else {
                    dp[row - 1][col1][col2] = grid[row - 1][col1] + grid[row - 1][col2];
                }
            }
        }

        // Iterate over remaining rows and columns
        for (int i = row - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < col; j1++) {
                for (int j2 = 0; j2 < col; j2++) {
                    int mx = Integer.MIN_VALUE;
                    for (int robo1 = -1; robo1 < 2; robo1++) {
                        for (int robo2 = -1; robo2 < 2; robo2++) {
                            int newCol1 = j1 + robo1;
                            int newCol2 = j2 + robo2;
                            if (newCol1 >= 0 && newCol1 < col && newCol2 >= 0 && newCol2 < col) {
                                int cherries = (j1 == j2) ? grid[i][newCol1] : grid[i][newCol1] + grid[i][newCol2];
                                mx = Math.max(mx, cherries + dp[i + 1][newCol1][newCol2]);
                            }
                        }
                    }
                    dp[i][j1][j2] = mx;
                }
            }
        }

        return Math.max(0, dp[0][0][col - 1]);
    }
}
