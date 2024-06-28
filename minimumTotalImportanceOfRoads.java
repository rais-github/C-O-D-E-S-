class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long importance = 0L;
        int [] degrees = new int[50001];
        //Count the degree (both indegree and outdegree)
        for(int []road:roads)
        {
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        // Either create a pair or an 2D-Array for degree and index(roads);
        int[][] nodes = new int[n][2];
        for (int i = 0; i < n; i++) {
            nodes[i][0] = degrees[i];  // degree
            nodes[i][1] = i;           // indexes(roads)
        }
        
        // Sort nodes based on degree in descending order and index in ascending order if degrees are the same
        Arrays.sort(nodes, (a, b) -> {
            if (b[0] != a[0]) {
                return Integer.compare(b[0], a[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        int[] importanceValues = new int[n]; // mark the importance value at road(index)
        for (int i = 0; i < n; i++) {
            importanceValues[nodes[i][1]] = n - i; // 5 , 4 , 3 , 2 , 1
        }

        for (int[] road : roads) {
            importance += importanceValues[road[0]] + importanceValues[road[1]]; // sum of the two cites ai and bi
        }

        return importance;
    }
}
