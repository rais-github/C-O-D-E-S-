class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length, m = graph[0].length;
        int color[] = new int[n];
        Arrays.fill(color, 0); 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int neighbor : graph[i]) {
                list.add(neighbor);
            }
            adj.add(list);
        }
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(adj, color, i, 0)) return false;
            }
        }
        return true;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int color[], int src, int clr) {
        if (color[src] != 0) {
            return color[src] == clr;
        }
        color[src] = clr;
        for (int neighbor : adj.get(src)) {
            if (!dfs(adj, color, neighbor, 1 - clr)) {
                return false;
            }
        }
        return true;
    }
}
