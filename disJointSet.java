import java.util.*;

class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    public int findUParent(int node) {
        if (node == parent.get(node)) return node;
        int prevParent = findUParent(parent.get(node));
        parent.set(node, prevParent);
        return prevParent;
    }

    public void unionByRank(int u, int v) {
        int ul_pu = findUParent(u);
        int ul_pv = findUParent(v);

        if (ul_pu == ul_pv) return;

        if (rank.get(ul_pu) < rank.get(ul_pv)) {
            parent.set(ul_pu, ul_pv);
        } else if (rank.get(ul_pu) > rank.get(ul_pv)) {
            parent.set(ul_pv, ul_pu);
        } else {
            parent.set(ul_pu, ul_pv);
            rank.set(ul_pv, rank.get(ul_pv) + 1);
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);

        ds.unionByRank(0, 1);
        ds.unionByRank(2, 3);
        ds.unionByRank(1, 4);

        System.out.println(ds.findUParent(0));  // Should print 1
        System.out.println(ds.findUParent(2));  // Should print 3
        System.out.println(ds.findUParent(4));  // Should print 1
    }
}
