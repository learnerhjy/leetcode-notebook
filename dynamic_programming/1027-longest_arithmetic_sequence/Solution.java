class Solution {
    public int longestArithSeqLength(int[] A) {
        int length = A.length;
        int[][] dp = new int[length][length];
        int ans = 0;
        // map 存储 value-index的list
        Map<Integer,List<Integer>> map = new HashMap<>();
        // 初始化为2
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++)
                dp[i][j] = 2;
        }

        for(int i=0;i<length;i++){
            List<Integer> temp = map.getOrDefault(A[i],new ArrayList<>());
            temp.add(i);
            map.put(A[i],temp);
            for(int j=i+1;j<length;j++){
                int diff = A[j]-A[i];
                if(map.containsKey(A[i]-diff)){
                    int k = -1;
                    int temp_max = 0;
                    List<Integer> l = map.get(A[i]-diff);
                    for(int cursor=0;cursor<l.size();cursor++){
                        int temp_index = l.get(cursor);
                        if(temp_index<i&&dp[temp_index][i]>temp_max)
                        {
                            k = temp_index;
                            temp_max = dp[k][i];
                        }
                    }
                    if(k!=-1)
                        dp[i][j] = dp[k][i] + 1;
                }
                ans = Math.max(ans,dp[i][j]);
            }
        }
    return ans;
    }
}