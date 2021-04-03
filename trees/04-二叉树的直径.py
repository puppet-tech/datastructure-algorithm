# coding:utf-8

# 问题：
# 求给定二叉树的直径
class Solution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        '''二叉树的直径----递归--easy'''
        # 1.二叉树的直径可看做左右两个子树的深度和再加1
        # 2.所以需要先求单边的深度，常规求法，使用递归
        # 3.定义一个self.ans保存深度（最大值）
        # 4.定义函数depth，使用递归，出口：当node为空，返回0
        self.ans = 1
        def depth(node):
            if not node:
                return 0
            l_depth = depth(node.left)
            r_depth = depth(node.right)
            self.ans = max(self.ans, l_depth+r_depth+1)
            return max(l_depth, r_depth) + 1

        depth(root)
        return self.ans - 1

    # 时间复杂度：O(n)，每个节点遍历一次
    # 空间复杂度：O(n)，递归使用栈
    # 这道题还要好好理解；