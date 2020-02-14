class Solution {

    private boolean isSubstring(String s,String t){
    	int pos_s = 0;
        char[] s_ = s.toCharArray();
        char[] t_ = t.toCharArray();
    	for(int i = 0;i<t.length()&& pos_s<s.length();i++)
    	{
            if(s_[pos_s] == t_[i])
                pos_s++;
        }       
        return pos_s == s.length();
    }

    public String minWindow(String S, String T) {
        if(T.length()>S.length())
            return "";
        
        int length = Integer.MAX_VALUE;
        int start = -1;
        int left = 0,right = 0;
        int[] counter = new int[26];
        Set<Character> t_set = new HashSet<>();
        Set<Character> s_set = new HashSet<>();
        char[] s_char = S.toCharArray();
        char[] t_char = T.toCharArray();

        for(int i=0;i<t_char.length;i++){
            t_set.add(t_char[i]);
        }

        while(right<S.length()){
            counter[s_char[right]-'a']++;
            if(t_set.contains(s_char[right]))
                s_set.add(s_char[right]);
            while(t_set.size()==s_set.size()&&isSubstring(T,S.substring(left,right+1))){
                if(right-left+1<length)
                {
                    start = left;
                    length = right - left + 1;
                }
                counter[s_char[left]-'a']--;
                if(counter[s_char[left]-'a']==0)
                    s_set.remove(s_char[left]);
                left++;
            }
            right++;
        }
        return start==-1?"":S.substring(start,start+length);
    }
}