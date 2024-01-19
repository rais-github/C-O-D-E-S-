import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row, col, dist;

    Pair(int r, int c, int d) {
        this.row = r;
        this.col = c;
        this.dist = d;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] vis = new int[m][n];
        int[][] res = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int dis = q.peek().dist;
            q.remove();
            res[row][col] = dis;

            for (int i = 0; i < 4; i++) {
                int nRow = row + drow[i];
                int nCol = col + dcol[i];

                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && mat[nRow][nCol] == 1) {
                    vis[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol, dis + 1));
                }
            }
        }
        return res;
    }
}
