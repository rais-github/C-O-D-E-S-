import java.util.ArrayList;
import java.util.HashSet;

class Solution {

    int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, vis, vec, grid, i, j);
                    st.add(vec);
                }
            }
        }

        return st.size();
    }

    private void dfs(int row, int col, int[][] vis, ArrayList<String> vec, int[][] grid, int baseR, int baseC) {
        vis[row][col] = 1;
        vec.add((baseR - row) + " " + (baseC - col));
        int n = grid.length, m = grid[0].length;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if (nRow < n && nRow >= 0 && nCol < m && nCol >= 0 && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, vis, vec, grid, baseR, baseC);
            }
        }
    }
}
