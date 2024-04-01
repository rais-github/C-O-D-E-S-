class DisjointSet {
    int parent[];
    int rank[];

    // Constructor for initializing the DisjointSet
    DisjointSet(int V) {
        // Initialize parent and rank arrays
        this.parent = new int[V];
        this.rank = new int[V];

        // Initialize each element's parent as itself and rank as 0
        for (int i = 0; i < V; i++) { 
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Method to find the ultimate parent of a node (with path compression)
    public int findUlp(int node) {
        if (node != parent[node]) {
            // Path compression by recursively setting each node's parent to its ultimate parent
            parent[node] = findUlp(parent[node]);
        }
        return parent[node];
    }

    // Method to union two sets by rank
    public void unionByRank(int u, int v) {
        // Find ultimate parents of both nodes
        int ulp_u = findUlp(u);
        int ulp_v = findUlp(v);

        // If they already belong to the same set, return
        if (ulp_u == ulp_v) return;

        // Merge the sets based on their ranks
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u;
        } else {
            // If ranks are equal, merge and increment rank of the parent(either of them can be merged to any one among them)
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}

class Solution {
    // Method to find the minimum time required to swim across the grid
    public int swimInWater(int[][] grid) {
        int n = grid.length; // Size of the grid
        int minTime = 0; // Minimum time required
        int N = n * n; // Total number of cells in the grid
        DisjointSet dsu = new DisjointSet(N); // Create DisjointSet object

        // Loop until the source and destination are in the same set
        do {
            // Iterate through each cell in the grid
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // If the current cell's time is greater than the current minimum time, skip
                    if(grid[i][j] > minTime) continue;
                    // Union neighboring cells if they are reachable within the current time
                    if (i + 1 < n && grid[i + 1][j] <= minTime) {// check that we don't swim out of the bound
                        dsu.unionByRank(i * n + j, (i + 1) * n + j); // i*n+j represents current cell and (i+1)*n+j represents cell below current (this is very common formula used in DSU with grids)
                    }
                    if (j + 1 < n && grid[i][j + 1] <= minTime) {// check that we don't swim out of the bound
                        dsu.unionByRank(i * n + j, i * n + j + 1);// i*n+j representing current cell and i*n+(j+1) for left 
                    }
                }
            }
            // Increment the minimum time
            minTime++;
        } while (dsu.findUlp(N - 1) != dsu.findUlp(0)); // Repeat until source and destination are in the same set
        
        // Return the minimum time minus 1 (as the loop exits after incrementing time)
        return minTime - 1;
    }
}
