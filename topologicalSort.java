import java.util.*;

class Solution {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        int idx = 0;
        int[] vis = new int[V];
        int[] res = new int[V];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, stk);
            }
        }

        while (!stk.isEmpty()) {
            res[idx++] = stk.pop();
        }
        return res;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> stk) {
        vis[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == 0) {
                dfs(neighbor, adj, vis, stk);
            }
        }
        stk.push(node);
    }
}
