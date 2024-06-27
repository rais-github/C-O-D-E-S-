class Solution {
    public int findCenter(int[][] edges) {
        if(edges[1][0] == edges[0][0] || edges[1][0] == edges[0][1])
            return edges[1][0];
        else return edges[1][1];
    }
}


// Appraoch 2 but slow 
class Solution {
    public int findCenter(int[][] edges) {
        int n = 0;
        for(int []edge:edges)
        {
            n = Math.max(n,edge[0]);
            n = Math.max(n,edge[1]);
        }
        int []indegree = new int[n+1];
        for(int []edge:edges)
        {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        for(int deg=0;deg<=n;deg++)
        {
            if(indegree[deg]==n-1) return deg;
        }
        return -1;
    }
}
