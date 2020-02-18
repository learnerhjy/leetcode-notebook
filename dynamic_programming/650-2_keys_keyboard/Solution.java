class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for(int i=2;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j<i;j++){
                if(i%j==0)
                    if(dp[j]+i/j<min)
                        min = dp[j]+i/j;
                dp[i] = min;
            }
        }
        return dp[n];
    }
}