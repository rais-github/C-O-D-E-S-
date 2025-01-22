class Pair {
    int first, second;

    public Pair(int _x, int _y) {
        this.first = _x;
        this.second = _y;
    }
}

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int[][] height = new int[n][m];
        ArrayDeque<Pair> q = new ArrayDeque<>();

        // Initialize heights and queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) { 
                    q.offer(new Pair(i, j));
                } else {
                    height[i][j] = -1; 
                }
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair cell = q.poll();
            int x = cell.first;
            int y = cell.second;

            for (int i = 0; i < 4; i++) {
                int newRow = x + dRow[i];
                int newCol = y + dCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && height[newRow][newCol] == -1) {
                    height[newRow][newCol] = height[x][y] + 1; 
                    q.offer(new Pair(newRow, newCol)); 
                }
            }
        }

        return height;
    }
}
