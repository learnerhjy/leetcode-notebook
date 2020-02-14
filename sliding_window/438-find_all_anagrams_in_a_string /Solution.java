class Solution {

    private boolean isMatch(String p,int[] counter_s,int[] counter_p){
        for(int i=0,length = p.length();i<length;i++){
            if(counter_s[p.charAt(i)-'a']!=counter_p[p.charAt(i)-'a'])
                return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        int length_s = s.length();
        int length_p = p.length();

        if(length_s==0||length_s<length_p)
            return res;

        int left = 0,right = length_p - 1;

        int[] counter_s = new int[26];
        int[] counter_p = new int[26];
        for(int i=0;i<length_p;i++){
           counter_s[s.charAt(i)-'a']++;
           counter_p[p.charAt(i)-'a']++;
        }

        while(right<length_s){
            if(isMatch(p,counter_s,counter_p)){
                res.add(left);
            }
            counter_s[s.charAt(left)-'a']--;
            left++;
            right++;
            if(right<length_s)
                counter_s[s.charAt(right)-'a']++;
        }
        return res;
    }
}