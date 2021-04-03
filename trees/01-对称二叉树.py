# coding:utf-8

# 问题：
# 给定一个二叉树，检查它是否是镜像对称的。
# 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        '''对称二叉树----递归--easy'''
        # 1.对称说明是二叉树呈镜像，则其要满足的条件为：
        # ①节点的左右子节点的值相同
        # ②左子节点的左子节点的值等于右子节点的右子节点的值
        # ③左子节点的右子节点的值等于右子节点的左子节点的值
        # 2.由此判断可用递归
        # 3.出口：当左右子节点为None，则True；当只是其中一个为None，则False
        return  self.is_mirror(root, root)  # 巧妙解决root为空的特殊情况

    def is_mirror(self, left_node, right_node):
        # 递归出口
        if left_node == None and right_node == None:
            return True
        elif left_node == None or right_node == None:
            return False
        else:
            if left_node.val == right_node.val:
                return self.is_mirror(left_node.left, right_node.right) and self.is_mirror(left_node.right, right_node.left)

        # 时间复杂度：O(n)，因为遍历了整棵树
        # 空间复杂度：O(n)，递归保存过程调用了栈