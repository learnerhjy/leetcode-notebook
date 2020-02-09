class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if(chars[0]=='0')
            return 0;
        int dp_pre = 1,dp_cur = 1;
        for(int i=1;i<s.length();i++){
            int temp = dp_cur;
            if(chars[i]=='0'){
                if(chars[i-1]=='1'||chars[i-1]=='2')
                {
                    dp_cur = dp_pre;
                }
                else
                    return 0;
            }
            else{
                int value = Integer.valueOf(s.substring(i-1,i+1));
                if(value<=26&&value>=10)
                    dp_cur = dp_cur + dp_pre;
            }
            dp_pre = temp;
        }
        return dp_cur;
    }
}

/*
    动态规划问题
    dp为动态规划数组 dp[i]表示第0到第i的序列的解码方法
    转换方程
        1. 当前数字为0
            1.1 前面数字为1或0 则当前解码方法与前一位的解码方法相同（当前的0必须与前面一位相结合）
                dp[i] = dp[i-1]
            1.2 前面数字非1和0 则直接返回0 即没有解码方法匹配当前的0 
                dp[i] = 0
        2. 当前数字非0 
            2.1 与前一位数字组成的数字值在10到26之间 则当前数字可单独解码也课余前一位数字结合 即
                dp[i] = dp[i-1] + dp[i-2]
            2.2 与前一位数字组成的数字值不在上述范围 则当前数字只能单独解码
                dp[i] = dp[i-1]
    注意到只需要dp[i] dp[i-1] dp[i-2] 三个状态 则使用滚动数组而不用维护一个动态数组可以实现常数级的空间复杂度
    需要注意base case 先判断第一位是否为0 若为0 直接返回0 否则当前解码方法为1 进行遍历
    
    Time Complexity O(n)
    Space Complexity O(1)
*/