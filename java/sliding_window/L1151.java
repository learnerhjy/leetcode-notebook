class Solution {
    public int minSwaps(int[] data) {
        int ans = Integer.MAX_VALUE;
        int window_size = 0;
        for(int num:data)
            window_size += num;

        if(window_size<=1)
            return 0;

        int right = 0;
        int count_one = 0;

        while(right<data.length){
            count_one += data[right];
            if(right>=window_size-1){
                ans = Math.min(ans,window_size-count_one);
                count_one -= data[right-window_size+1];
            }
            right++;
        }
        return ans;
    }
}