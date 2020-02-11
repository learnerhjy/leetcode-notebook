class Solution {

    private boolean isMatch(String s,int[] counter_1,int[] counter_2){
        for(int i=0,length = s.length();i<length;i++){
            if(counter_1[s.charAt(i)-'a']!=counter_2[s.charAt(i)-'a'])
                return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int length_1 = s1.length();
        int length_2 = s2.length();
        if(length_2==0||length_2<length_1)
            return false;
        int left = 0,right = length_1 - 1;
        int[] counter_1 = new int[26];
        int[] counter_2 = new int[26];

        for(int i=0;i<length_1;i++){
           counter_1[s1.charAt(i)-'a']++;
           counter_2[s2.charAt(i)-'a']++;
        }
        while(right<length_2){
            if(isMatch(s1,counter_1,counter_2)){
                return true;
            }
            counter_2[s2.charAt(left)-'a']--;
            left++;
            right++;
            if(right<length_2)
                counter_2[s2.charAt(right)-'a']++;
        }
        return false;
    }
}