# coding: utf-8
# question:
# 给定一个二叉树，返回其节点值自底向上的层次遍历。
# （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历
class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        '''二叉树的层次遍历----广度优先遍历--easy'''
        # 1.使用广度优先遍历思想，但是需要记录每次的层次
        # 2.每层的值，需要用列表存起来，遍历完每层后，把列表insert到结果列表的头部
        # 3.考虑特殊情况：①root为None；
        if root == None:
            return
        ans = []  # 数组，存放最终答案
        cur = [root]  # 游标，遍历指向各层；开始先指向第一层
        while cur:  # 当当前层不为空时；为空说明没有下一层了，树遍历结束
            current_layer_val = []
            next_layer_node = []
            for node in cur:  # 遍历每一层的节点
                current_layer_val.append(node.val)
                if node.left is not None:  # node的左右节点如果为空，添加到层数组中，层次中就会有空；
                    next_layer_node.append(node.left)
                if node.right is not None:
                    next_layer_node.append(node.right)
            cur = next_layer_node  # 让右边指向下一层
            ans.insert(0, current_layer_val)  # 把当前层的值插入到结果数组的头部
        return ans
