class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0, board.length, board[0].length);
    }

    public static boolean helper(char[][] board, int row, int col, int er, int ec) {
        if (row == er) {
            return true;
        }

        int newRow = 0, newCol = 0;
        if (col != ec - 1) {
            newCol = col + 1;
            newRow = row;
        } else {
            newRow = row + 1;
            newCol = 0;
        }

        if (board[row][col] != '.') {
            return helper(board, newRow, newCol, er, ec);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isValid(board, row, col, i, er, ec)) {
                    board[row][col] = (char) (i + '0');
                    if (helper(board, newRow, newCol, er, ec)) {
                        return true;
                    }
                    board[row][col] = '.'; // Backtrack
                }
            }
        }
        return false;
    }

    protected static boolean isValid(char[][] board, int row, int col, int n, int er, int ec) {
        for (int i = 0; i < er; i++) {
            if (board[i][col] == (char) (n + '0')) return false;
            if (board[row][i] == (char) (n + '0')) return false;
        }

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char) (n + '0')) return false;
            }
        }

        return true;
    }
}
