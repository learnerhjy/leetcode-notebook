class Solution {

    private void dfs(int i,int j,StringBuilder sb,int[][] grid,int m,int n){
        if(i<0||i>=m||j<0||j>=n||grid[i][j]==0)
            return;
        grid[i][j] = 0;
        dfs(i+1,j,sb.append("u"),grid,m,n);
        dfs(i-1,j,sb.append("d"),grid,m,n);
        dfs(i,j+1,sb.append("r"),grid,m,n);
        dfs(i,j-1,sb.append("l"),grid,m,n);
    }


    public int numDistinctIslands(int[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int m = grid.length,n = grid[0].length;
        Set<String> set = new HashSet<>();

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)
                    continue;
                StringBuilder sb = new StringBuilder();
                dfs(i,j,sb,grid,m,n);
                set.add(sb.toString());
            }
        
        return set.size();
    }
}