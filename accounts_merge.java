import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size(); // Corrected variable declaration
        DisjointSet ds = new DisjointSet(n);
        // create a emailToIndex map         
        Map<String, Integer> emailToIndex = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if(!emailToIndex.containsKey(mail)) {
                    emailToIndex.put(mail, i);
                } else {
                    ds.unionBySize(i, emailToIndex.get(mail));
                }
            }
        }

        ArrayList<String>[] merged = new ArrayList[n]; // Corrected array declaration
        for(int i = 0; i < n; i++) {
            merged[i] = new ArrayList<String>();
        }
        for(Map.Entry<String, Integer> it : emailToIndex.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUp(it.getValue()); // Corrected method name
            merged[node].add(mail);
        }

        List<List<String>> mergedResult = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(merged[i].size() == 0) continue;
            Collections.sort(merged[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : merged[i]) {
                temp.add(it);
            }
            mergedResult.add(temp);
        }
        return mergedResult;
    }
}

class DisjointSet {
    List<Integer> parent;
    List<Integer> size;

    public DisjointSet(int V) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUp(int node) { // Corrected method name
        if (node != parent.get(node)) {
            parent.set(node, findUp(parent.get(node))); // Path compression
        }
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int up_u = findUp(u); // Corrected method name
        int up_v = findUp(v); // Corrected method name

        if (up_u != up_v) {
            if (size.get(up_u) < size.get(up_v)) {
                parent.set(up_u, up_v);
                size.set(up_v, size.get(up_v) + size.get(up_u));
            } else {
                parent.set(up_v, up_u);
                size.set(up_u, size.get(up_v) + size.get(up_u));
            }
        }
    }
}
