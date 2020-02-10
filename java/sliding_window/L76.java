class Solution {
    
    private boolean isMatch(char[] t_char,int[] match,int[] counter){
        for(int i=0;i<t_char.length;i++)
            if(match[t_char[i]-'A']>counter[t_char[i]-'A'])
                return false;
        return true;
    }

    public String minWindow(String s, String t) {
        //Map<Character,Integer> map = new HashMap<>();
        int[] match = new int[58];
        int[] counter = new int[58];
        int left = 0,right = 0;
        int start = -1;
        int min_length = Integer.MAX_VALUE;
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        for(int i=0;i<t_char.length;i++){
            match[t_char[i]-'A']++;
        }
        while(right<s_char.length){
            counter[s_char[right]-'A']++;
            while(isMatch(t_char,match,counter)){
                if(right-left+1<min_length){
                    min_length = right-left+1;
                    start = left;
                }
                counter[s_char[left]-'A']--;
                left++;
            }
            right++;
        }
        if(start==-1)
            return "";
        return s.substring(start,start+min_length);
    }
}