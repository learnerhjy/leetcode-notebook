class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int length = A.length;
        int[][] dp = new int[length][length];
        int ans = 0;
        for(int i=0;i<length;i++)
            for(int j=0;j<length;j++)
                dp[i][j] = 2;
        // map 存 value-index
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++){
            map.put(A[i],i);
            for(int j=i+1;j<length;j++){
                if(A[j]-A[i]>=A[i])
                    break;
                if(map.containsKey(A[j]-A[i]))
                    dp[i][j] = dp[map.get(A[j]-A[i])][i]+1;
                ans = Math.max(dp[i][j],ans);
            }
        }
        return ans==2?0:ans;
    }
}