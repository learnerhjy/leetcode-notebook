class Solution {
    /*
    private Set<Integer> used = new HashSet<>();

    private void backtracking(int[] nums,List<List<Integer>> res, LinkedList<Integer> path){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int num:nums)
            if(!used.contains(num)){
                used.add(num);
                path.add(num);
                backtracking(nums,res,path);
                path.removeLast();
                used.remove(num);
            }
    }*/

    private void backtracking(int first,List<List<Integer>> res,List<Integer> path,int n){
        if(first == n)
            res.add(new ArrayList<>(path));
        for(int i=first;i<n;i++){
            Collections.swap(path,first,i);
            backtracking(first+1,res,path,n);
            Collections.swap(path,first,i);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length==0)
            return res;
        List<Integer> path = new ArrayList<>(nums.length);
        for(int num:nums)
            path.add(num);

        backtracking(0,res,path,nums.length);
        return res;
    }
}

/*
这道题用java来做，也能看到在解决回溯问题时使用java和python的一些区别。
首先是被注释部分的代码 使用used数组来记录元素访问情况 使用了LinkedList作为路径 和python的list相比还是有些麻烦的
下面的解法没有使用used数组，而是使用了swap函数保证了数字不会被重复使用。
swap操作的时间复杂度为O(1)，通过源码可以看到其中调用了ArrayList的get和set方法

*/
