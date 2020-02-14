class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null||s.length()==0||k==0)
            return 0;
        int left = 0,right = 0;
        int length = s.length();
        int ans = 0;
        char[] s_char = s.toCharArray();

        Set<Character> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();

        while(right<length){
            set.add(s_char[right]);
            while(set.size()>k){
                if(left==map.get(s_char[left]))
                    set.remove(s_char[left]);
                left++;
            }
            ans = Math.max(ans,right-left+1);
            map.put(s_char[right],right);
            right++;
        }
        return ans;
    }
}