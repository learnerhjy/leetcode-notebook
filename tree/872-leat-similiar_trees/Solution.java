/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void helper(TreeNode root,List<Integer> leaf){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            leaf.add(root.val);
            return;
        }
        helper(root.left,leaf);
        helper(root.right,leaf);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        helper(root1,leaf1);
        helper(root2,leaf2);
        if(leaf1.size()!=leaf2.size())
            return false;
        for(int i=0;i<leaf2.size();i++)
            if(leaf1.get(i)!=leaf2.get(i))
                return false;
        return true;

    }
}