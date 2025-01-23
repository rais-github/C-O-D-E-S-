class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        DisjointSet ds = new DisjointSet(n * m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    
                    for (int k = 0; k < m; k++) {
                        if (grid[i][k] == 1) {
                            ds.unionBySize(i * m + j, i * m + k);
                        }
                    }
                    
                    for (int k = 0; k < n; k++) {
                        if (grid[k][j] == 1) {
                            ds.unionBySize(i * m + j, k * m + j);
                        }
                    }
                }
            }
        }

        int[] componentSize = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int parent = ds.findParent(i * m + j);
                    componentSize[parent]++;
                }
            }
        }

        int count = 0;
        for (int size : componentSize) {
            if (size > 1) count += size;
        }
        return count;
    }
}

class DisjointSet {
    private int[] rank, parent, size;

    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }

    public void unionByRank(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) return;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
