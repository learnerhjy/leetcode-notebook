class Solution {
    private int dfs(TreeNode root,List<List<Integer>> res){
        if(root==null)
            return 0;
        int left = dfs(root.left,res);
        int right = dfs(root.right,res);
        int cur = Math.max(left,right)+1;
        if(cur>res.size())
            res.add(new ArrayList<Integer>());
        List<Integer> temp = res.get(cur-1);
        temp.add(root.val);
        return cur;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,res);
        return res;
    }
}