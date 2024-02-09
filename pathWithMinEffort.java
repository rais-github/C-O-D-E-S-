class Tuple {
    int row, col, diff;

    Tuple(int row, int col, int diff) {
        this.row = row;
        this.col = col;
        this.diff = diff;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.diff - y.diff);
        int n = heights.length, m = heights[0].length;
        int[][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Tuple it = pq.poll();
            int diff = it.diff;
            int nodeRow = it.row;
            int nodeCol = it.col;

            if (nodeRow == n - 1 && nodeCol == m - 1) return diff;

            for (int i = 0; i < 4; i++) {
                int newRow = nodeRow + dRow[i];
                int newCol = nodeCol + dCol[i];

                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m) {
                    int effort = Math.max(Math.abs(heights[nodeRow][nodeCol] - heights[newRow][newCol]), diff);
                    if (effort < distance[newRow][newCol]) {
                        distance[newRow][newCol] = effort;
                        pq.add(new Tuple(newRow, newCol, effort));
                    }
                }
            }
        }

        // If the destination is not reachable, you can return -1 or any other appropriate value
        return -1;
    }
}
