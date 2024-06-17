class Tuple {
    int first, second, third;

    // Constructor corrected to assign values properly
    Tuple(int dis, int row, int col) {
        first = dis;
        second = row;
        third = col;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        if(grid[0][0]==0 && n==1 && m==1) return 1;//[[0]]

        // Check if the top-left or bottom-right cells are obstacles
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }

        // Create distance matrix
        int[][] dist = new int[n][m];

        // Initialize the source cell with distance 0
        dist[0][0] = 0;

        // Mark the rest of the cells as very far, initially set to (int)1e9
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        // Queue to store {distance, row, cell} -> create Tuple
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 0, 0));

        // 8-directions movement array
        int[] dRow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dCol = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int distance = it.first;
            int row = it.second;
            int col = it.third;

            for (int i = 0; i < 8; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                // Boundary check and check if the cell is reachable and not visited
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 0
                        && distance + 1 < dist[newRow][newCol]) {
                    dist[newRow][newCol] = distance + 1;
                    // Check if we have reached the destination cell
                    if (newRow == n - 1 && newCol == m - 1) {
                        return distance + 2; // Return distance + 2 since we started from (0, 0) with distance 0
                    }
                    q.add(new Tuple(distance + 1, newRow, newCol));
                }
            }
        }
        // If we reach here, there is no path to the destination
        return -1;
    }
}
