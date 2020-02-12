class Solution {
    public int closedIsland(int[][] grid) {
        if(grid.length==0||grid[0].length==0)
            return 0;

        int m = grid.length,n = grid[0].length;
        int ans = 0;
        Set<String> set = new HashSet<>();
        int[][] dires = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==0&&!set.contains(i+"."+j))
                {   
                    Queue<int[]> queue = new LinkedList<>();
                    boolean flag = true;
                    int[] temp = {i,j};
                    queue.offer(temp);
                    set.add(i+"."+j);
                    while(!queue.isEmpty()){
                        temp = queue.poll();
                        for(int k=0;k<4;k++){
                            int new_i = temp[0] + dires[k][0];
                            int new_j = temp[1] + dires[k][1];
                            if(new_i>=0&&new_i<m&&new_j>=0&&new_j<n&&grid[new_i][new_j]==0&&!set.contains(new_i+"."+new_j)){
                                set.add(new_i+"."+new_j);
                                int[] temp_ = {new_i,new_j};
                                queue.offer(temp_);
                                if(new_i==0||new_i==m-1||new_j==0||new_j==n-1){
                                    flag = false;
                                }

                            }
                        }  
                    }
                    if(flag)
                        ans++;
                }
            }
        }

        return ans;
    }
}

/*
    岛屿问题
    dfs bfs 可解 这里使用bfs
    bfs使用队列进行遍历 并记录遍历过的位置
    每一轮bfs中 如果找到边界的0 修改flag 继续进行遍历（不要停下来）
    每轮结束时 根据flag判断该岛屿是否完全被水包围 更新ans

    Time Complexity O(n)
    Space Complexity O(n)
*/