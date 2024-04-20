class Pair {
    int row = 0, col = 0;

    Pair(int first, int second) {
        this.row = first;
        this.col = second;
    }
}

class Solution {
    public int[][] findFarmland(int[][] land) {
        int rows = land.length, cols = land[0].length;
        if (rows == 1 && cols == 1) {
            if(land[0][0]==0)  return new int[][]{};
            return new int[][]{{0,0,0,0}};
        }
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[rows][cols];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (land[row][col] == 1 && vis[row][col] == 0) {
                    ArrayList<Integer> farmland = new ArrayList<>();
                    q.add(new Pair(row, col));
                    vis[row][col] = 1;
                    int farthestRow = row, farthestCol = col;

                    while (!q.isEmpty()) {
                        Pair item = q.poll();
                        int r = item.row, c = item.col;

                        farthestRow = Math.max(farthestRow, r);
                        farthestCol = Math.max(farthestCol, c);

                        for (int i = 0; i < 4; i++) {
                            int newRow = r + dRow[i];
                            int newCol = c + dCol[i];
                            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                                    land[newRow][newCol] == 1 && vis[newRow][newCol] == 0) {
                                vis[newRow][newCol] = 1;
                                q.add(new Pair(newRow, newCol));
                            }
                        }
                    }

                    farmland.add(row);
                    farmland.add(col);
                    farmland.add(farthestRow);
                    farmland.add(farthestCol);
                    ans.add(farmland);
                }
            }
        }

        int[][] result = new int[ans.size()][4];
        for (int i = 0; i < ans.size(); i++) {
            ArrayList<Integer> farmland = ans.get(i);
            for (int j = 0; j < 4; j++) {
                result[i][j] = farmland.get(j);
            }
        }
        return result;
    }
}
