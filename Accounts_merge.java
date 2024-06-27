class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        List<List<String>> mergedAccounts = new ArrayList<>();
        HashMap<String, Integer> emailToIndex = new HashMap<String, Integer>();
        ArrayList<String>[] mergedMail = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    ds.unionBySize(i,emailToIndex.get(email));
                }
            }
            mergedMail[i] = new ArrayList<String>();
        }

        for (Map.Entry<String, Integer> it : emailToIndex.entrySet()) {
            String email = it.getKey();
            int node = ds.findUlp(it.getValue());
            mergedMail[node].add(email);
        }

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0)
                continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<String>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail[i]);
            mergedAccounts.add(new ArrayList<>(temp));
        }

        return mergedAccounts;
    }
    
}

class DisjointSet {
    int[] parent;
    int[] size;
    int[] rank;

    public DisjointSet(int V) {
        this.parent = new int[V];
        this.size = new int[V];
        this.rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
            rank[i] = 0;
        }
    }

    public int findUlp(int node) {
        if (node == parent[node]) return node;
        parent[node] = findUlp(parent[node]); 
        return parent[node];
    }

    public void unionBySize(int u, int v) {
        int Pu = findUlp(u);
        int Pv = findUlp(v);
        if (Pu == Pv)
            return;
        else if (size[Pu] < size[Pv]) {
            parent[Pu] = Pv;
            size[Pv] += size[Pu];
        } else {
            parent[Pv] = Pu;
            size[Pu] += size[Pv];
        }
    }

    public void unionByRank(int u, int v) {
        int Pu = findUlp(u);
        int Pv = findUlp(v);
        if (Pu == Pv)
            return;
        else if (rank[Pu] < rank[Pv]) {
            parent[Pu] = Pv;
        } else if (rank[Pu] > rank[Pv]) {
            parent[Pv] = Pu;
        } else {
            parent[Pu] = Pv;
            rank[Pv] = rank[Pu] + 1;
        }
    }

    public int findComponents() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (i == findUlp(i))
                count++;
        }
        return count;
    }
}
