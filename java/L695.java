class Solution {
    private int ans = 0;
    private int cur_ans = 1;
    private int[][] dires = {{0,1},{0,-1},{1,0},{-1,0}};

    private boolean isValid(int i,int j,int m,int n){
        if(i<0||i>m-1||j<0||j>n-1)
            return false;
        return true;
    }

    private void dfs(int i,int j,int m,int n,Set<String> set,int[][] grid){
        if(!(isValid(i,j,m,n)&&!set.contains(i+"."+j)&&grid[i][j]==1))
            return;
        set.add(i+"."+j);
        cur_ans ++;
        for(int k=0;k<4;k++){
            dfs(i+dires[k][0],j+dires[k][1],m,n,set,grid);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return ans;
        
        int m = grid.length,n = grid[0].length;
        Set<String> set = new HashSet<>();

        for(int i = 0;i<m;i++)
            for(int j=0;j<n;j++){
                cur_ans = 0;
                dfs(i,j,m,n,set,grid);
                ans = Math.max(ans,cur_ans);
            }
        
        return ans;
        
    }
}

/*
    岛屿
    dfs或bfs都可解
    使用dfs 需要注意的是
        1. set保存遍历过的位置 也可不使用set直接在原矩阵上修改
        2. 注意越界
        3. 使用全局变量保存每一轮dfs的结果 并与ans对比 更新ans

    Time Complexity O(n)
    Space Complexity O(n) 
*/