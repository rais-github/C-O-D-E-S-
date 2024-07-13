class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Stack<Integer> stk = new Stack<>();
        int moves = 0;

        // Populate the map with positions and corresponding robot data
        for(int pos = 0 ; pos < positions.length ; pos++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(pos + 1); // Index (1-based)
            temp.add(healths[pos]); // Health
            int val = directions.charAt(pos) == 'R' ? 1 : -1; // Direction: 1 for 'R', -1 for 'L'
            temp.add(val);
            map.put(positions[pos], temp);
        }

        Arrays.sort(positions); // Sort positions for sequential processing

        while(map.size() > 1 && moves < positions.length) {
            // no collison simply add and move ahead
            if (stk.isEmpty() || map.get(stk.peek()).get(2) == map.get(positions[moves]).get(2)) {
                stk.push(positions[moves]);
                moves++;
            } else { // Collision
                int pos1 = stk.peek();
                int robo1 = map.get(pos1).get(1);
                int dir1 = map.get(pos1).get(2);
                int pos2 = positions[moves];
                int robo2 = map.get(pos2).get(1);
                int dir2 = map.get(pos2).get(2);
                moves++;

                if (robo1 == robo2) {
                    // Both robots destroy each other
                    stk.pop();
                    map.remove(pos1);
                    map.remove(pos2);
                } else if (robo1 > robo2) {
                    // The robot in the stack survives but loses health
                    map.get(pos1).set(1, robo1 - 1);
                    map.remove(pos2);
                } else {
                    // The current robot survives but loses health
                    map.get(pos2).set(1, robo2 - 1);
                    stk.pop();
                    map.remove(pos1);
                }
            }
        }

       List<int[]> survivedRobots = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            survivedRobots.add(new int[] { entry.getValue().get(0), entry.getValue().get(1) });
        }

        survivedRobots.sort(Comparator.comparingInt(a -> a[0]));

        List<Integer> result = new ArrayList<>();
        for (int[] robot : survivedRobots) {
            result.add(robot[1]);
        }
        return result;
    }

    
}
