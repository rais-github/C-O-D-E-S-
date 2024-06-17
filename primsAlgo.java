   class Pair {
    int node, distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    static int spanningTree(int V, int E, int edges[][]) {
        // Code Here.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] vis = new int[V];

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        pq.add(new Pair(0, 0));
        int sum = 0;

        while (pq.size() > 0) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1) continue;

            vis[node] = 1;
            sum += wt;

            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                int weight = neighbor.distance;
                if (vis[nextNode] == 0) {
                    pq.add(new Pair(nextNode, weight));
                }
            }
        }

        return sum;
    }
}
