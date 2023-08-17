class Solution {
    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        queen(0, new boolean[n][n], n, res);
        return res.size();
    }

    public static void queen(int cr, boolean[][] board, int n, List<List<String>> res) {
        if (cr == n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        row.append("Q");
                    } else {
                        row.append(".");
                    }
                }
                ans.add(row.toString());
            }
            res.add(ans);
            return;
        }
        
        for (int cc = 0; cc < n; cc++) {
            if (canBePlaced(board, cr, cc, n)) {
                board[cr][cc] = true;
                queen(cr + 1, board, n, res);
                board[cr][cc] = false;
            }
        }
    }

    public static boolean canBePlaced(boolean[][] board, int cr, int cc, int n) {
        for (int row = 0; row < cr; row++) {
            if (board[row][cc]) {
                return false;
            }
        }
        
        int row = cr;
        int col = cc;
        while (row >= 0 && col < n) {
            if (board[row][col]) {
                return false;
            }
            row--;
            col++;
        }
        
        row = cr;
        col = cc;
        while (row >= 0 && col >= 0) {
            if (board[row][col]) {
                return false;
            }
            row--;
            col--;
        }
        
        return true;
    }
}
