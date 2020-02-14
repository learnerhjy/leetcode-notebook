class Solution {
    public int longestOnes(int[] A, int K) {
        int count = 0;
        int left = 0,right = 0;
        int ans = 0;
        while(right<A.length){
            if(A[right]==1)
                count++;
            while(right-left+1>count+K){
                if(A[left]==1)
                    count--;
                left++;
            }

            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}