class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        /*
            dp[i][k] 表示 A[:i+1]分成k组的最优解
            要求的结果是 dp[A.length-1][K]
            basecase dp[i][1] = sum(A[:i+1])/i
            转换方程
            dp[i][k] = dp[j][k-1] + sum(dp[j+1,i+1])/(i-j+1) (0<=j<i)
        */

        int length = A.length;
        double [][] dp = new double[length+1][K+1];
        double[] sum = new double[length+1];
        for(int i=1;i<=length;i++){
            sum[i] = sum[i-1] + A[i-1];
            dp[i][1] = sum[i]/i;
        }
        for(int i=1;i<length+1;i++)
            for(int k=2;k<=K;k++)
                for(int j=k-1;j<i;j++){
                    dp[i][k] = Math.max(dp[i][k],dp[j][k-1]+(sum[i]-sum[j])/(i-j));
                }
        return dp[length][K];
    }
}