class Solution {
    Integer memo[][];
    public int minFallingPathSum(int[][] matrix) {
        memo=new Integer[matrix.length][matrix.length];
        int mn = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            int temp = solve(0, j, matrix);
            mn = Math.min(mn, temp);
        }
        return mn;
    }

    private int solve(int r, int c, int[][] matrix) {
        if(memo[r][c]!=null) return memo[r][c];
        int n = matrix.length;
        if (r == n - 1) {
            return matrix[r][c];
        }

        int down = solve(r + 1, c, matrix);
        int left = (c > 0) ? solve(r + 1, c - 1, matrix) : Integer.MAX_VALUE;
        int right = (c < n - 1) ? solve(r + 1, c + 1, matrix) : Integer.MAX_VALUE;

        return memo[r][c]=matrix[r][c] + Math.min(down, Math.min(left, right));
    }
}
