import java.util.*;

class Solution {
    public String findOrder(String[] dict, int N, int K) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(K, adj);
        StringBuilder res = new StringBuilder();
        for (int it : topo) {
            res.append((char) (it + (int) ('a')));
        }
        return res.toString();
    }

    private List<Integer> topoSort(int k, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[k];
        for (int i = 0; i < k; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);
            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        return result;
    }
}
