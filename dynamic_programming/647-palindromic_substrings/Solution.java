class Solution {
    public int countSubstrings(String s) {
        int length = s.length();
        int ans = length;
        boolean[][] dp = new boolean[length][length];
        for(int i=0;i<length;i++)
            dp[i][i] = true;
        for(int i=length-1;i>=0;i--)
            for(int j=i+1;j<length;j++){
                if(j-i==1)
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                else
                    dp[i][j] = dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                if(dp[i][j])
                    ans++;
            }       
        return ans;
    }
}
