class Pair{
    int first,second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
    
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean []vis = new boolean[V];
        for(int i=0;i<V;i++) vis[i]=false;
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(check(i,vis,adj)) return true;
            }
        }
        return false;
    }
    private boolean check(int src,boolean[]vis,ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(src,-1));
        while(!q.isEmpty()){
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int adjacentNode:adj.get(node)){
                if(vis[adjacentNode]==false){
                    vis[adjacentNode]=true;
                    q.add(new Pair(adjacentNode,node));
                }
                else if(parent!=adjacentNode){
                    return true;
            }
        }
    }
    return false;
}}
