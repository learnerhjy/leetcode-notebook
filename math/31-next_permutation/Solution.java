class Solution {
    public void nextPermutation(int[] nums) {
        // 从后往前找到第一个下降的数
        // 将该数与其后面的第一个比它大的数交换
        // 翻转

        int index = -1;
        for(int i=nums.length-2;i>=0;i--)
            if(nums[i]<nums[i+1])
            {
                index = i;
                break;
            }
        
        if(index!=-1){
            for(int i=nums.length-1;i>index;i--)
                if(nums[i]>nums[index]){
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
        }

        for(int i=0;i<(nums.length-1-index)/2;i++){
            int temp = nums[i+index+1];
            nums[i+index+1] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }
    }
}

/*
    经典题目
*/