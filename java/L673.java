class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;

        int ans = 0;
        int max_length = 1;
        // 记录以当前索引结束的最长递增子序列长度
        int[] length = new int[nums.length];
        // 记录以当前索引结束的最长递增子序列个数
        int[] count = new int[nums.length];
        // 进行初始化 
        Arrays.fill(length,1);
        Arrays.fill(count,1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    // 从0到i-1遍历 找到最大值
                    if(length[j]>=length[i]){
                        length[i] = length[j]+1;
                        count[i] = count[j];
                    }
                    // 若小于说明length[i]已经更新过 为了找出个数需要判断length[i]-length[j]==1
                    else{
                        count[i]+= length[i]-length[j]==1?count[j]:0;
                    }

                }
            }

            // 更新最大值
            max_length = Math.max(max_length,length[i]);
        }

        for(int i=0;i<nums.length;i++){
            if(length[i]==max_length)
                ans += count[i];
        }
        return ans;
    }
}