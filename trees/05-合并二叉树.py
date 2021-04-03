# coding:utf-8

# question:
# 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
# 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
# 那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
class Solution:
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:  # 类型注释
        '''merge Binary Tree----递归--easy'''
        # 1.如果两棵树都为空，则直接返回None
        # 2.如果两棵树都不为空，则合并
        # 3.如果两棵树其中有一棵为空，则直接返回不为空的树
        # 4.合并：可用递归；拆分成小步骤，每次相当于两棵小子树的合并，每个小步骤中，只需要合并子树根节点，需要注意的是，子树合并后，需要用根节点的前驱区和后继区连接起来，并在合并最后返回t1
        if t1 == None and t2 == None:
            return None
        elif t1 and t2:
            t1.val = t1.val + t2.val
            t1.left = self.mergeTrees(t1.left, t2.left)
            t1.right = self.mergeTrees(t1.right, t2.right)
            return t1
        else:
            return t1 or t2

    # 时间复杂度：O(n)
    # 空间复杂度：O(n)
