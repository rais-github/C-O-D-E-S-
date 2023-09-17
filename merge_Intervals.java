import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int l = intervals.length;
        if (l <= 1) {
            return intervals; 
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> res = new ArrayList<>();
        
        int beg = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < l; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[]{beg, end});
                beg = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{beg, end});

        int numRows = res.size();
        int[][] twoDArray = new int[numRows][2];

        for (int i = 0; i < numRows; i++) {
            twoDArray[i] = res.get(i);
        }
        
        return twoDArray;
    }
}
