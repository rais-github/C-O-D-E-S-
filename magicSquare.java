class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int countMagic = 0;
        int rows = grid.length, cols = grid[0].length;
        
        if (rows < 3 || cols < 3) return 0;

        for (int r = 0; r <= rows - 3; r++) {
            for (int c = 0; c <= cols - 3; c++) {
                if (isMagicSquare(grid, r, c)) {
                    countMagic++;
                }
            }
        }

        return countMagic;
    }

    private boolean isMagicSquare(int[][] grid, int r, int c) {
        // check  1 to 9
        boolean []isSeen = new boolean [10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[r + i][c + j];
                if (num < 1 || num > 9 ||isSeen[num]) {
                    return false;
                }
                isSeen[num]=true;
            }
        }

        // check sum for row , col and diagonal
        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2]; // rowSum
        
        for (int i = 0; i < 3; i++) {
            //row
            if (grid[r + i][c] + grid[r + i][c + 1] + grid[r + i][c + 2] != sum) {
                return false;
            }
            //col
            if (grid[r][c + i] + grid[r + 1][c + i] + grid[r + 2][c + i] != sum) {
                return false;
            }
        }

        //main diagonal
        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != sum) {
            return false;
        }

        //leading diagonal
        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != sum) {
            return false;
        }

        return true;
    }
}
