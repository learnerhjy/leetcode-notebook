class Solution {
    public int maxCoins(int[] nums) {
        if(nums==null)
            return 0;
        int length = nums.length;
        if(length==0)
            return 0;
        int[][] dp = new int[length+2][length+2];
        int[] nums2 = new int[length+2];
        System.arraycopy(nums,0,nums2,1,length);
        nums2[0] = 1;
        nums2[length+1] = 1;
        for(int i=length+1;i>=0;i--){
            for(int j=i+2;j<length+2;j++){
                int temp = 0;
                for(int k=i+1;k<j;k++){
                    if(dp[i][k]+dp[k][j]+nums2[i]*nums2[j]*nums2[k]>temp)
                        temp = dp[i][k]+dp[k][j]+nums2[i]*nums2[j]*nums2[k];
                }
                dp[i][j] = temp;
            }
        }
        return dp[0][length+1];
    }
}