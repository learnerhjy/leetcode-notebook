class Solution {

    private int function(int a,int b,int c,int x){
        return a*(int)Math.pow(x,2) + b*x + c;
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int length = nums.length;
        int[] res = new int[length];
        if(a==0){
            if(b>=0){
                for(int i=0;i<length;i++){
                    res[i] = function(a,b,c,nums[i]);
                }
            }
            else{
                for(int i=0;i<length;i++){
                    res[i] = function(a,b,c,nums[length-i-1]);
                }                
            }
        }
        else{
            double sym = -b/(2.0*a);
            int sym_nearest_index = 0;
            double distance = Math.abs(nums[0]-sym);
            for(int i=1;i<length;i++){
                if(Math.abs(nums[i]-sym)<distance){
                    distance = Math.abs(nums[i]-sym);
                    sym_nearest_index = i;
                }
            }
            res[0] = function(a,b,c,nums[sym_nearest_index]);
            int i=1;
            int left = sym_nearest_index-1;
            int right = sym_nearest_index+1;
            while(left>=0&&right<length){
                if(Math.abs(nums[left]-sym)<Math.abs(nums[right]-sym))
                    res[i++] = function(a,b,c,nums[left--]);
                else
                    res[i++] = function(a,b,c,nums[right++]);
            }
            if(right<length)
                for(int j=right;j<length;j++)
                    res[i++] = function(a,b,c,nums[j]);
            if(left>=0)
                for(int j=left;j>=0;j--)
                    res[i++] = function(a,b,c,nums[j]);

            if(a<0){
                for(int j=0;j<length/2;j++){
                    int temp = res[j];
                    res[j] = res[length-j-1];
                    res[length-j-1] = temp;
                }
            }
        }
        return res;
    }
}


/*
    思路
    a b c为函数的三个系数 显然需要进行分类讨论
    1. a等于0 原方程为一次函数 函数单调性由b的正负决定
    2. a不等于0 原方程为二次函数 函数值大小由自变量到对称轴的距离和a的正负共同决定
        2.1 a大于0
            自变量到对称轴越远 函数值越大
        2.2 a小于0
            自变量到对称轴越近 函数值越大

    具体实现
    a等于0时容易 重点是a不等于0的情况
    在原数组中找到离对称轴距离最近的自变量 再使用两个指针向数组两端遍历
    注意a的正负

    Time complexity O(n)
    Space complexity O(1)

*/