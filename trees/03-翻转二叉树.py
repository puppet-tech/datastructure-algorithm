# coding:utf-8

# 翻转一颗二叉树

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        '''翻转二叉树----递归--easy'''
        # 1.翻转二叉树，其实就是分别对所有节点的左右子树进行交换
        # 2.完成翻转，得先对最深层的节点进行翻转，可用递归
        # 3.每次递归后返回一棵完成翻转的子树，再将子树链接到根节点中
        # 4.出口：节点为空
        if root == None:
            return root
        else:
            left_tree = self.invertTree(root.left)
            right_tree = self.invertTree(root.right)
            root.right = left_tree
            root.left = right_tree
            return root

    # 时间复杂度：O(n)，遍历每个节点
    # 空间复杂度：O(n)，递归时栈的调用