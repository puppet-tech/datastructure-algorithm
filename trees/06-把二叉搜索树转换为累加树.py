# coding:utf-8
# question:
# 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
# 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
class Solution:
    def __init__(self):
        # 应该定义成实例属性，如果定义成类属性，那么下一个测试实例进来的时候，会累积temp的值
        self.temp = 0  # 定义临时变量保存后一个累加值，前一个只需要加上这个累加值就可以了
    def convertBST(self, root: TreeNode) -> TreeNode:
        '''把二叉搜索树转换为累加树----逆中序遍历--easy'''
        # 1.二叉搜索树的特性：left > root > right
        # 2.利用二叉搜索树的特性，可以使用逆中序遍历
        # 出口：当传入的节点为空是，返回
        if root == None:
            return
        else:
            self.convertBST(root.right)
            root.val += self.temp
            self.temp = root.val
            self.convertBST(root.left)
            return root

    # 时间复杂度：O(n)
    # 空间复杂度：O(n)