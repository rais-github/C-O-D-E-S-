class Solution {
    public boolean exist(char[][] board, String word) {
        int er = board.length;
        int ec = board[0].length;
        boolean[][] vis = new boolean[er][ec]; 
        for (int i = 0; i < er; i++) {
            for (int j = 0; j < ec; j++) {
                if (search(board, word, i, j, 0, vis)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean search(char[][] board, String word, int cr, int cc, int index, boolean[][] vis) {
        if (index == word.length()) {
            return true;
        }
        
        if (cr < 0 || cc < 0 || cr >= board.length || cc >= board[0].length || vis[cr][cc] || board[cr][cc] != word.charAt(index)) {
            return false;
        }
        
        vis[cr][cc] = true;
        
        boolean found = search(board, word, cr + 1, cc, index + 1, vis)
                     || search(board, word, cr - 1, cc, index + 1, vis)
                     || search(board, word, cr, cc + 1, index + 1, vis)
                     || search(board, word, cr, cc - 1, index + 1, vis);
        
        vis[cr][cc] = false;
        
        return found;
    }
}
