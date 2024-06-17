import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        // If the source is the same as the target
        if (target.equals("0000")) return 0;

        // Check if the source is in deadends
        HashSet<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        if (deadendSet.contains("0000")) return -1;

        // Apply BFS for shortest path
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return level;
                if (deadendSet.contains(current)) continue;

                // Generate neighbors
                for (int j = 0; j < 4; j++) {
                    char[] arr = current.toCharArray();
                    // Increment digit
                    char original = arr[j];
                    arr[j] = original == '9' ? '0' : (char) (original + 1);
                    String next = new String(arr);
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                    // Decrement digit
                    arr[j] = original == '0' ? '9' : (char) (original - 1);
                    next = new String(arr);
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
