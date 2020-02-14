class Solution {
    public int minDistance(String word1, String word2) {
        int length_1 = word1.length();
        int length_2 = word2.length();

        int[][] dp = new int[length_1+1][length_2+1];
        char[] word1_char = word1.toCharArray();
        char[] word2_char = word2.toCharArray();

        for(int i=0;i<length_2+1;i++)
            dp[0][i] = i;
        for(int i=0;i<length_1+1;i++)
            dp[i][0] = i;
        for(int i=1;i<length_1+1;i++)
            for(int j=1;j<length_2+1;j++){
                if(word1_char[i-1]==word2_char[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else
                {
                    int min = dp[i-1][j-1];
                    if(dp[i-1][j]<min)
                        min = dp[i-1][j];
                    if(dp[i][j-1]<min)
                        min = dp[i][j-1];
                    dp[i][j] = min + 1;
                }
            }
        
        return dp[length_1][length_2];
    }
}
