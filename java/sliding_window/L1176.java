class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        if(k<=0)
            return 0;
        int ans = 0;
        int t = 0;
        int right = 0;
        while(right<calories.length){
            t += calories[right];
            if(right>=k-1){
                if(t<lower)
                    ans--;
                if(t>upper)
                    ans++;
                t -= calories[right+1-k];
            }
            right++;
        }
        return ans;
    }
}