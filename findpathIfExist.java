import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Construct adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int vertex = 0; vertex < n; vertex++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // Initialize disjoint set
        DisjointSet ds = new DisjointSet(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            ds.unionBySize(u, v);
        }

        // Check if source and destination belong to the same set
        return ds.findUlp(source) == ds.findUlp(destination);
    }
}

class DisjointSet {
    int parent[];
    int size[];

    DisjointSet(int V) {
        this.parent = new int[V];
        this.size = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUlp(int node) {
        if (node == parent[node]) return node;
        int prevParent = findUlp(parent[node]);
        parent[node] = prevParent; // Path compression
        return prevParent;
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUlp(u);
        int ulp_v = findUlp(v);
        if (ulp_u == ulp_v) return; // Already in the same set
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}
