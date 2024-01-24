class Solution {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, V, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int V, ArrayList<ArrayList<Integer>> adj, int[] color) {
        if (color[node] == -1) {
            color[node] = 0; // Assign the current node to one of the colors (0 or 1)
        }

        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == -1) {
                color[neighbor] = 1 - color[node]; // Assign the opposite color to the neighbor
                if (!dfs(neighbor, V, adj, color)) {
                    return false;
                }
            } else if (color[neighbor] == color[node]) {
                return false; // The graph is not bipartite if there is an edge between nodes with the same color
            }
        }
        return true;
    }
}
