class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int m = grid.length,n = grid[0].length;

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int lines = 4;
                    if(i>0&&grid[i-1][j]==1)
                        lines--;
                    if(i<m-1&&grid[i+1][j]==1)
                        lines--;
                    if(j>0&&grid[i][j-1]==1)
                        lines--;
                    if(j<n-1&&grid[i][j+1]==1)
                        lines--;
                    ans += lines;                    
                }
            }
        return ans;
    }
}

/*
    这道题本来想复杂了 dfs或者bfs
    看了题解的解法才知道一遍遍历就够了
    核心是一块陆地对于总周长的贡献等于 4-其周围陆地的数量

    Time Complexity O(n)
    Space Complexity O(1)
*/