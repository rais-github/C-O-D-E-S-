class Pair {
    int first, second;

    Pair(int row, int col) {
        this.first = row;
        this.second = col;
    }
}

class Tuple {
    int first, second, third;

    Tuple(int stops, int node, int cost) {
        this.first = stops;
        this.second = node;
        this.third = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple currentTuple = q.poll();
            int stops = currentTuple.first;
            int node = currentTuple.second;
            int cost = currentTuple.third;

            if (stops > k) continue;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.first;
                int edgeWeight = neighbor.second;

                if (cost + edgeWeight < dist[adjNode] && stops <= k) {
                    dist[adjNode] = edgeWeight + cost;
                    q.add(new Tuple(stops + 1, adjNode, edgeWeight + cost));
                }
            }
        }

        return (dist[dst] == Integer.MAX_VALUE) ? -1 : dist[dst];
    }
}
