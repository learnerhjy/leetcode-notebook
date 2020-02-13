class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if(K>S.length())
            return 0;
        int[] counter = new int[26];
        Set<Character> set = new HashSet<>();

        int ans = 0;
        int right = 0;
        char[] s = S.toCharArray();
        while(right<S.length()){
            set.add(s[right]);
            counter[s[right]-'a']++;
            if(right>=K-1){
                if(set.size()==K)
                    ans++;
                counter[s[right-K+1]-'a']--;
                if(counter[s[right-K+1]-'a']==0)
                    set.remove(s[right-K+1]);
            }
            right++;
        }       
        return ans; 
    }
}