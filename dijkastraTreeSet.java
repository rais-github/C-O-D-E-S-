class Pair {
    int node, distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        TreeSet<Pair> set = new TreeSet<>((x, y) -> {
            if (x.distance == y.distance) {
                return Integer.compare(x.node, y.node);
            }
            return Integer.compare(x.distance, y.distance);
        });

        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int) 1e9;
        }
        dist[S] = 0;
        set.add(new Pair(S, 0));

        while (!set.isEmpty()) {
            int node = set.first().node;
            int distance = set.first().distance;
            set.remove(set.first());

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (distance + edgeWeight < dist[adjNode]) {
                    set.remove(new Pair(adjNode, dist[adjNode])); // Remove old entry
                    dist[adjNode] = distance + edgeWeight;
                    set.add(new Pair(adjNode, dist[adjNode]));    // Add updated entry
                }
            }
        }
        return dist;
    }
}
