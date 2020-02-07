class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3)
            return false;
        int first = nums[0],second = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>second)
                return true;
            else if(nums[i]>first)
                second = nums[i];
            else
                first = nums[i];
        }
        return false;
    }
}

/*
    思路
    1.暴力解法
        维护一个length数组 记录每个位置所对应的最大递增子序列长度 初始化length[0]为1
        遍历原数组 对于每一个索引i 找到length数组中0~i-1索引中的最大值 +1 即为length[i]的值
        即 length[i] = max(length[j])+1 (0<=j<i&&nums[j]<nums[i])
        Time complexity O(n^2)
    2.双指针法
        一次遍历就找到结果 维护两个指针first second分别指向递增子序列中的第一个值和第二个值 
        初始化 first=nums[0] second为正无穷
        遍历原数组 
                2.1 若当前值大于second 已经找到三元递增子序列 返回true
                2.2 否则若当前值大于first 更新second为当前值
                2.3 否则更新first为当前值
        Time complexity O(n)
        Space complexity O(1)
*/