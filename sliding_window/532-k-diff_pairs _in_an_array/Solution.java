class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums==null||nums.length<=1||k<0)
            return 0;
        Arrays.sort(nums);
        int ans = 0;
        int left = 0,right = 1;
        if(k==0){
            boolean flag = true;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]==nums[i+1])
                    flag = false;
                else{
                    if(!flag)
                        ans++;
                    flag = true;
                }
            }
            if(nums[nums.length-1]==nums[nums.length-2])
                ans++;
            return ans;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        while(right<nums.length){
            if(map.getOrDefault(nums[right]-k,-1)>=left){
                ans++;
                //System.out.println("left:"+left+".right:"+right);
                left = map.get(nums[right]-k)+1;
            }
            map.put(nums[right],right);
            right++;
        }
        return ans;
    }
}