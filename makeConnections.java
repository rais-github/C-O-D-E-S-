class Solution {
    public int makeConnected(int n, int[][] connections) {
        // Number of connections must be at least n-1
        if (connections.length < n - 1) return -1;

        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;

        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];

            // If they are already in the same component, it means this is an extra edge
            if (ds.findUlp(a) == ds.findUlp(b)) {
                extraEdges++;
            } else {
                ds.unionBySize(a, b);
            }
        }

        // The number of operations required to connect all components
        int components = ds.connectedComponents();
        return components - 1;
    }
}

class DisjointSet {
    private int[] parent;
    private int[] size;

    public DisjointSet(int V) {
        this.parent = new int[V];
        this.size = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUlp(int node) {
        if (node == parent[node]) return node;
        parent[node] = findUlp(parent[node]);
        return parent[node];
    }

    public void unionBySize(int u, int v) {
        int up = findUlp(u);
        int vp = findUlp(v);

        if (up == vp) return;

        if (size[up] < size[vp]) {
            parent[up] = vp;
            size[vp] += size[up];
        } else {
            parent[vp] = up;
            size[up] += size[vp];
        }
    }

    public int connectedComponents() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) count++;
        }
        return count;
    }
}
