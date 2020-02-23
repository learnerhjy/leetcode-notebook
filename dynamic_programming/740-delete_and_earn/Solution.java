class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num:nums)
            max = Math.max(max,num);
        int[] counter = new int[max+1];
        for(int num:nums)
            counter[num]++;
        int dp_0 = 0,dp_1 = 0;
        for(int i=1;i<=max;i++){
            int temp = dp_1;
            dp_1 = Math.max(dp_1,dp_0+counter[i]*i);
            dp_0 = temp;
        }
        return dp_1;
    }
}