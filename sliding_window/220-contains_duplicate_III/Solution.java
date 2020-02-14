class Solution {

    private boolean isValid(List<Integer> queue,int t){
        if(queue.size()<=1)
            return false;
        int first = queue.get(0);
        boolean flag = false;
        for(Integer num:queue){
            if(!flag){
                flag = true;
            }
            else{
                if(Math.abs((long)first-num)<=t){
                    return true;
                }

            }
        }   
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int window_size = k + 1;
        int right = 0;
        List<Integer> queue = new LinkedList<>();
        while(right<nums.length){
            queue.add(nums[right]);

            if(right>k){
                queue.remove(0);
            }
            if(isValid(queue,t))
                return true;
            right++;
        }

        for(int i=right-k;i<right;i++){
            queue.remove(0);
            if(isValid(queue,t))
                return true;
        }
        return false;
    }
}