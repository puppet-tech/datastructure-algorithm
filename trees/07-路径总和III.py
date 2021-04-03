# coding:utf-8
# question:
# 给定一个二叉树，它的每个结点都存放着一个整数值。
# 找出路径和等于给定数值的路径总数。
# 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
        '''路径总和III----递归、先序遍历--easy'''
        # 1.假设路径从根节点开始，那么可用递归，遍历每一子树，则从根节点开始的路径＋左右子节点的路径＝路径总和
        # 2.如何求from根节点开始的路径呢？
        # 3.再用一个递归to get，每遍历一个节点，先判断节点的值与sum是否相等，如果相等，则路径＋1
        # 如果不等，则sum - node.val传入递归
        # 4.出口：节点为空，返回0
        if root == None:
            return 0
        else:
            return self.paths(root, sum) + self.pathSum(root.left, sum) + self.pathSum(root.right, sum)

    def paths(self, node, sum):
        '''求一个根节点的路径数'''
        if node == None:
            return 0
        else:
            res = 0
            if node.val == sum:  # 等于它之后，还要继续下面的操作，因为数值存在负数，可能回归0
                res += 1
            res += self.paths(node.left, sum-node.val)
            res += self.paths(node.right, sum-node.val)
            return res

    # 双重递归，时间复杂度和空间复杂度都太大了, 最好用一重递归 ＋ 回溯会好很多。



