class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0,right = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while(right<nums.length){
            sum += nums[right];
            while(sum>=s){
                ans = Math.min(ans,right-left+1);
                sum -= nums[left];
                left++;

            }
            right ++;
        }
        if(ans==Integer.MAX_VALUE)
            return 0;
        return ans;
    }
}