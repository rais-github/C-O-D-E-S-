class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int []distance = new int[n];
        for(int i=0;i<n;i++) distance[i]=(int)1e9;
        distance[src]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            for(int it:adj.get(node)){
                if(distance[node]+1<distance[it]){
                    distance[it]=1+distance[node];
                    q.add(it);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(distance[i]==1e9){
                distance[i]=-1;
            }
        }
        return distance;
    }
}
