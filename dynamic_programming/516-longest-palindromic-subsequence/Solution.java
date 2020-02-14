class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        
        // 定义dp数组 dp[i][j]的意义为s[i..j]的最长回文序列长度
        int[][] dp = new int[length][length];
        
        // 初始化dp i<j为0 i=j为1
        for(int i=0;i<length;i++)
            dp[i][i] = 1;
        
        char[] s_char = s.toCharArray();

        for(int i=length-1;i>=0;i--)
            for(int j=i+1;j<length;j++)
            {
                if(s_char[i]==s_char[j])
                    dp[i][j] = dp[i+1][j-1]+2;
                else
                    dp[i][j] = dp[i+1][j]>dp[i][j-1]?dp[i+1][j]:dp[i][j-1];
            }
        
        return dp[0][length-1];
        
    }
}
