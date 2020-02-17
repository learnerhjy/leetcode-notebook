class Solution {
    private int getHeight(TreeNode root){
        if(root==null)
            return 0;
        return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }

    private void helper(TreeNode root,int height,int start,int end,List<List<String>> res){
        if(root==null)
            return;
        List<String> temp = res.get(height);
        temp.set((start+end)/2,Integer.toString(root.val));
        helper(root.left,height+1,start,(start+end)/2-1,res);
        helper(root.right,height+1,(start+end)/2+1,end,res);
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        List<List<String>> res = new ArrayList<>(height);
        for(int i=0;i<height;i++){
            List<String> temp = new ArrayList<>((int)Math.pow(2,height)-1);
            for(int j=0;j<(int)Math.pow(2,height)-1;j++)
                temp.add("");
            res.add(temp);
        }
        helper(root,0,0,(int)Math.pow(2,height)-2,res);
        return res;

    }
}