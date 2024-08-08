class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] coordinates = new int[rows * cols][2];
        int[] dirR = {0, 1, 0, -1}; 
        int[] dirC = {1, 0, -1, 0}; 
        
        int step = 1; 
        int index = 0;
        
        coordinates[index++] = new int[]{rStart, cStart}; 
        
        while (index < rows * cols) {
            for (int i = 0; i < 4; i++) { 
                for (int j = 0; j < step; j++) {
                    rStart += dirR[i];
                    cStart += dirC[i];
                    
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        coordinates[index++] = new int[]{rStart, cStart};
                    }
                    
                    if (index == rows * cols) return coordinates;
                }
                
                if (i % 2 == 1) step++;
            }
        }
        
        return coordinates;
    }
}
