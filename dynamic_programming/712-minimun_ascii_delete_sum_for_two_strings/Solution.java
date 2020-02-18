class Solution {
    public int minimumDeleteSum(String s1, String s2) {
          // 找s1和s2之间ASCII码最大的公共子序列
          int max = 0;
          int ans = 0;
          int dp[][] = new int[s1.length()+1][s2.length()+1];
          char[] s1_char = s1.toCharArray();
          char[] s2_char = s2.toCharArray();
          for(int i=0;i<s1_char.length;i++){
            ans += (int)s1_char[i];
            for(int j=0;j<s2_char.length;j++){
                if(s1_char[i]==s2_char[j])
                    dp[i+1][j+1] = dp[i][j] + (int)s1_char[i];
                else
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
            }
          }

        max = dp[s1_char.length][s2_char.length];

        for(char ch:s2_char)
            ans += (int)ch;
        ans -= 2*max;
        return ans;
    }
}