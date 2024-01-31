public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt=0, xor=0;

        // Initialize map with (0,1) to handle the case when XOR becomes equal to B
        map.put(0, 1);

        for (int i : A) {
            xor = xor ^ i;

            // Calculate the complement XOR value
            int complement = xor ^ B;

            // Check if the complement XOR value exists in the map
            if (map.containsKey(complement)) {
                cnt += map.get(complement);
            }

            // Update the map with the current XOR value
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return cnt;
        
    }
}
