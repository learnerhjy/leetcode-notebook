class Solution {
    public int numWays(int n, int k) {
        if(n==0)
            return 0;
        // 0代表必须涂与上一个post相同的 1代表一定能不凃与上一个post相同的
        int dp_0 = 0,dp_1 = k;
        for(int i=1;i<n;i++){
            int temp = dp_0;
            dp_0 = dp_1;
            dp_1 = (temp+dp_1)*(k-1);
        }
        return dp_0+dp_1;
    }
}
