class Solution {
private:
    bool isSafe(vector<vector<bool>>& board, int row, int col, int n) {
        // Check the same column in previous rows
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // Check the upper-left diagonal
        int r = row, c = col;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) return false;
            r--;
            c--;
        }

        // Check the upper-right diagonal
        r = row; c = col;
        while (r >= 0 && c < n) {
            if (board[r][c]) return false;
            r--;
            c++;
        }

        return true; // It's safe to place the queen
    }

public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<vector<bool>> board(n, vector<bool>(n, false)); // Initialize the board
        queen(res, board, 0, n); // Start placing queens from row 0
        return res;
    }

private:
    void queen(vector<vector<string>>& res, vector<vector<bool>>& board, int row, int boardSize) {
        if (row == boardSize) {
            // If all queens are placed, convert board to a result format
            vector<string> temp;
            for (int i = 0; i < boardSize; i++) {
                string s;
                for (int j = 0; j < boardSize; j++) {
                    s += board[i][j] ? "Q" : ".";
                }
                temp.push_back(s);
            }
            res.push_back(temp);
            return;
        }

        // Try placing a queen in every column of the current row
        for (int col = 0; col < boardSize; col++) {
            if (isSafe(board, row, col, boardSize)) {
                board[row][col] = true;  // Place the queen
                queen(res, board, row + 1, boardSize);  // Recur to place the next queen
                board[row][col] = false;  // Backtrack and remove the queen
            }
        }
    }
};
