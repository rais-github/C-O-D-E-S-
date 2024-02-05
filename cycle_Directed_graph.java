import java.util.ArrayList;

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, vis, pathVis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfsCheck(int node, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        pathVis[node] = 1;
        
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfsCheck(it, vis, pathVis, adj)) {
                    return true;
                }
            } else if (pathVis[it] == 1) {
                // If the adjacent node is already visited and in the current path, then there is a cycle.
                return true;
            }
        }
        
        // Backtrack
        pathVis[node] = 0;
        return false;
    }
}
