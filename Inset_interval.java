class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }// if given intervals are empty , newInterval is the answer

        List<int[]> merged = new ArrayList<>();// to create the our answer array the end by adding intervals 
        boolean placed = false;// flag to check was the newInterval even placed in the interval ?

        for (int[] interval : intervals) { // traverse the Intervals array
            if (interval[1] < newInterval[0]) {
                merged.add(interval);// if the newInterval exceeds the current interval , then it will check ahead and the currentInteval will be added as has'nt overlapped
            } else if (interval[0] > newInterval[1]) {// if the current intervals is capable of having the newInterval 
                if (!placed) {// if the newInterval is not placed yet
                    merged.add(newInterval);// add the new Interval first as ascending order is to be maintained
                    placed = true;// mark as placed
                }
                merged.add(interval);// place the current interval 
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);// update the newInterval's first element for further computation
                newInterval[1] = Math.max(interval[1], newInterval[1]);//update the newInterval's  second element for further computation
            }
        }

        if (!placed) { // if the newInterval was never Placed thereby place it at the add
            merged.add(newInterval);
        }

        return merged.toArray(new int[merged.size()][]);// convert the list to 2-D matrix as asked returned type
    }
}
