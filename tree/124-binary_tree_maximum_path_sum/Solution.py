# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.ans = float("-inf")
    def maxPathSum(self, root: TreeNode) -> int:
        def helper(root):
            if root is None:
                return 0
            left_sum = helper(root.left)
            right_sum = helper(root.right)
            self.ans = max(self.ans,left_sum+right_sum+root.val)
            return max(left_sum,right_sum)+root.val if max(left_sum,right_sum)+root.val>0 else 0
        helper(root)
        return self.ans

'''
    二叉树的问题 大部分都能通过递归/dfs来解决
    一种常见的套路是设置一个类属性存储结果 每次递归对其进行更新 同时又可以利用一次递归的返回值记录某些信息
    此问题使用ans保存最大路径和 返回条件是节点为空 返回0
    当前节点对应的最大路径和大于0时返回 否则返回0 因为负值不会对最大路径有贡献

    Time Complexity O(n) (每个节点都遍历一次)
    Space Complexity O(1) (不考虑递归的栈帧大小的话)
'''