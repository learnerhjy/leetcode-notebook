class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n<=1)
            return (int)Math.pow(10,n);
        int dp_pre = 1;
        int dp_cur = 10;
        
        int ans = 0;
        
        for(int i=2;i<n+1;i++){
            int temp = dp_cur;
            dp_cur = dp_cur + (11-i)*(dp_cur-dp_pre);
            dp_pre = temp;
        }
        return dp_cur;   
    }
}

