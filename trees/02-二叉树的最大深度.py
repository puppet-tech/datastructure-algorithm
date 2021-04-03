# coding:utf-8

# 给定一颗二叉树，求其最大深度

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        '''二叉树的最大深度----递归--easy'''
        # 1.先判断二叉树是否为空，如果为空，直接返回0
        # 2.使用递归，调用原方法maxDepth分别计算左右子树的高度
        # 3.取左右子树高度的最大值加1
        if root == None:
            return 0
        left_height = self.maxDepth(root.left)
        right_height = self.maxDepth(root.right)
        return max(left_height, right_height) + 1

    # 时间复杂度：O(n)
    # 空间复杂度：O(n)