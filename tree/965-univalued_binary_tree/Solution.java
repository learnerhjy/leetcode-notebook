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
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        int value = root.val;
        while(root!=null){
            if(root.left==null){
                if(root.val!=value)
                    return false;
                root = root.right;
            }else{
                TreeNode temp = root.left;
                while(temp.right!=null&&temp.right!=root)
                    temp = temp.right;
                if(temp.right==root){
                    if(root.val!=value)
                        return false;
                    root = root.right;
                    temp.right = null;
                }else{
                    temp.right = root;
                    root = root.left;
                }
            }
        }
        return true;
    }
}