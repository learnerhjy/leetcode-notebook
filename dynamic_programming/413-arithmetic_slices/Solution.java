class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int length = A.length;
        int ans = 0;
        boolean[][] dp = new boolean[length][length];
        for(int i=0;i<length-2;i++)
            if(A[i]+A[i+2]==2*A[i+1]){
                dp[i][i+2] = true;
                    ans++;
            }
   
        
        for(int i=0;i<length;i++){
            for(int j=i+3;j<length;j++){
                if(dp[i][j-1])
                    dp[i][j] = (A[j-2]+A[j]==2*A[j-1]);
                if(dp[i][j])
                    ans++;
            }
        }
        return ans;
    }
}