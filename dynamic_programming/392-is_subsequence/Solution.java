class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        int j=0;
        for(int i=0;i<t_char.length;i++){
            if(j==s_char.length)
                break;
            if(s_char[j]==t_char[i])
                j++;
        }
        return j==s_char.length;
    }
}