class Solution {
    public int maxRepOpt1(String text) {
        if(text==null||text.length()==0)
            return 0;
        int[] total = new int[58];
        char[] text_char = text.toCharArray();
        for(int i=0;i<text_char.length;i++){
            total[text_char[i]-'A']++;
        }

        char max_char = 'a';
        int[] counter = new int[58];
        int max_count = 0;
        int left = 0,right = 0;
        int ans = 0;
        while(right<text_char.length){
            counter[text_char[right]-'A']++;
            if(counter[text_char[right]-'A']>=max_count){
                max_char = text_char[right];
                max_count = counter[max_char-'A'];
            }
            while(right-left+1>max_count+1){  
                counter[text_char[left]-'A']--;
                left++;
            }
            ans = Math.max(ans,Math.min(right-left+1,total[max_char-'A']));
            right++;
        }
        return ans;
    }
}