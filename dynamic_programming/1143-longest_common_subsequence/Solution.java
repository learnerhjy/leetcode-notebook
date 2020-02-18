class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j]表示 text1[:i+1]和text2[:j+1]的最大子序列
        // if(text[i]!=text[j])
        //      dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        //  else dp[i][j] = dp[i-1][j-1] + 1
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1+1][length2+1];
        char[] text1_char = text1.toCharArray();
        char[] text2_char = text2.toCharArray();
        for(int i=0;i<length1;i++)
            for(int j=0;j<length2;j++){
                if(text1_char[i]!=text2_char[j])
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                else
                    dp[i+1][j+1] = dp[i][j] + 1;       

            }
        return dp[length1][length2];
    }
}