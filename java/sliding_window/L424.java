class Solution {

    private int[] counter = new int[26];

    public int characterReplacement(String s, int k) {
        if(s==null||s.length()==0)
            return 0;

        int left = 0,right =0;
        int max_count = 0;
        int ans = 0;
        char[] s_char = s.toCharArray();
        int length = s.length();
        while(right<length){
            counter[s_char[right]-'A']++;
            max_count = Math.max(max_count,counter[s_char[right]-'A']);
            right++;
            while(max_count+k<right-left){
                counter[s_char[left]-'A']--;
                left ++;
            }
            ans = Math.max(ans,right-left);
        }
        return ans;
        
    }
}