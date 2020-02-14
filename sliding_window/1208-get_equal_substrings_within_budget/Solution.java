class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0,right = 0;
        int ans = 0;
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        while(right<s.length()){
            maxCost -= s_char[right]-t_char[right]>=0?s_char[right]-t_char[right]:t_char[right]-s_char[right];
            while(maxCost<0){
                maxCost += s_char[left]-t_char[left]>=0?s_char[left]-t_char[left]:t_char[left]-s_char[left];
                left++;
            }
            if(right-left+1>ans)
                ans = right-left+1;
            right++;
        }
        return ans;
    }
}