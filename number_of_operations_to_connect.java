class DisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public DisjointSet(int v) {
        for (int i = 0; i < v; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUlp(int node) {
        if (node == parent.get(node)) return node;
        int prevParent = findUlp(parent.get(node));
        parent.set(node, prevParent);
        return prevParent;
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUlp(u);
        int ulp_v = findUlp(v);

        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extras = 0;
        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];
            if (ds.findUlp(a) == ds.findUlp(b)) extras++;
            else ds.unionBySize(a, b);
        }

        int connectedComponents = 0;
        for (int i = 0; i < n; i++) {
            if (i == ds.findUlp(i)) connectedComponents++;
        }

        return connectedComponents - 1 <= extras ? connectedComponents - 1 : -1;
    }
}
