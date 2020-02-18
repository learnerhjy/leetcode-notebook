class Solution {
    public int minDistance(String word1, String word2) {
        // 找到最长公共子序列
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1+1][length2+1];
        char[] word1_char = word1.toCharArray();
        char[] word2_char = word2.toCharArray();
        for(int i=0;i<length1;i++)
            for(int j=0;j<length2;j++){
                if(word1_char[i]==word2_char[j])
                    dp[i+1][j+1] = dp[i][j] + 1;
                else 
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
            }
        
        return length1+length2 - 2*dp[length1][length2];

    }
}