class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp_0 = 0,dp_1 = 0;
        for(int i=2;i<cost.length+1;i++){
            int temp = dp_1;
            dp_1 = Math.min(dp_1+cost[i-1],dp_0+cost[i-2]);
            dp_0 = temp;
        }
        return dp_1;
    }
}