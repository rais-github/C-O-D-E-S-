class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int m = times.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(times[i][0]-1).add(new Pair(times[i][1]-1 , times[i][2]));
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k-1] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k-1, 0));

        while (!q.isEmpty()) {
            Pair item = q.poll();
            int node = item.first;
            int cost = item.second;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.first;
                int edgeWeight = neighbor.second;

                if (cost + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = cost + edgeWeight;
                    q.add(new Pair(adjNode, cost + edgeWeight));
                }
            }
        }

        int minT = Integer.MIN_VALUE;
        for (int it : distance) {
            minT = Math.max(minT, it);
        }

        return minT == Integer.MAX_VALUE ? -1 : minT;
    }
}
