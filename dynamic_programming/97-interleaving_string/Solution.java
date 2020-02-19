class Solution {

    private char[] s1_char;
    private char[] s2_char;
    private char[] s3_char;

    private boolean helper(int i,int j,int k){
        if(i==s1_char.length&&j==s2_char.length&&k==s3_char.length)
            return true;
        if(k==s3_char.length)
            return false;
        if(i==s1_char.length)
        {
            if(j==s2_char.length)
                return false;
            if(s2_char[j]!=s3_char[k])
                return false;
            else
                return helper(i,j+1,k+1);
        }
        else if(j==s2_char.length){
            if(i==s1_char.length)
                return false;
            if(s1_char[i]!=s3_char[k])
                return false;
            else
                return helper(i+1,j,k+1);       
        }
        else{
            if(s1_char[i]==s3_char[k]&&s2_char[j]==s3_char[k])
                return helper(i+1,j,k+1)||helper(i,j+1,k+1);
            else if(s1_char[i]==s3_char[k])
                return helper(i+1,j,k+1);
            else if(s2_char[j]==s3_char[k])
                return helper(i,j+1,k+1);
            else return false;
        }
    }


    public boolean isInterleave(String s1, String s2, String s3) {
       // dp[i][j][k] s1[i:] s2[j:] 是否能组成 s3[k:]
       // basecase 三个都为最末 true 任意一个为空 false
       // 转化方程
       /*
            if s1[i]!=s3[k]&&s2[j]!=s3[k]
                dp[i][j][k]=false
            else
                dp[i][j][k] = dp[i][j+1][k+1] || dp[i+1][j][k+1]

                
       */
        this.s1_char = s1.toCharArray();
        this.s2_char = s2.toCharArray();
        this.s3_char = s3.toCharArray();
        if(s1_char.length+s2_char.length!=s3_char.length)
            return false;
        return helper(0,0,0);
        
    }
}