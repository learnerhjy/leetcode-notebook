class Solution {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int length_A = A.length;
        int length_B = B.length;
        int[][] dp = new int[length_A+1][length_B+1];
        for(int i=length_A-1;i>=0;i--)
            for(int j=length_B-1;j>=0;j--){
                if(A[i]==B[j])
                    dp[i][j] = dp[i+1][j+1] + 1;
                if(dp[i][j]>ans)
                    ans = dp[i][j];
            }
        return ans;
    }
}