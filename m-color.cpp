bool isSafeToAssign(int i, int j, vector<int>&color , bool graph[101][101], int n)
    {
        for(int k=0; k<n; k++)
        {
            if(graph[i][k] == 1 && color[k] == j)return false;
        }
        return true;
    }
    
    
    
    bool solve(bool graph[101][101], int m, int n, int i, vector<int>&color)
    {
        if(i==n)return true;
        
        for(int j=0; j<m; j++)
        {
            if(isSafeToAssign(i, j, color, graph, n))
            {
                color[i] = j;
                if(solve(graph, m, n, i+1, color))return true;
                color[i] = -1;
            }
        }
        return false;
    }
    
    
    bool graphColoring(bool graph[101][101], int m, int n) {
        // your code here
        vector<int>color(n, -1);
        return solve(graph, m, n, 0, color);
    }