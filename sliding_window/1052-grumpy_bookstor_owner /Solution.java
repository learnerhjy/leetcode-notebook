class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int base_num = 0;
        int incr_num = 0;
        int cur_num = 0;

        int right = 0;
        while(right<grumpy.length){
            if(grumpy[right]==1)
                cur_num += customers[right];
            else
                base_num += customers[right];
            if(right>=X-1){
                incr_num = Math.max(incr_num,cur_num);
                if(right+1-X<customers.length&&grumpy[right+1-X]==1)
                    cur_num -= customers[right+1-X];
            }
            right++;
        }
        return base_num + Math.max(incr_num,cur_num);
    }
}