# coding: utf-8
# question:
# 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
# 时间限制 1 秒，空间限制 32768K
# Difficulty: easy
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # 返回从尾部到头部的列表值序列，例如[1,2,3]
    def printListFromTailToHead(self, listNode):
        '''stack'''
        # 1.先顺序遍历链表，把每个值都append入栈
        # 2.当所有值都入栈之后，再用reverse倒一下就得到了想要的结果
        if listNode == None:
            return []
        stack_ = []
        cur = listNode
        while cur != None:
            stack_.append(cur.val)  # append:O(1); insert:O(n)
            cur = cur.next
        return stack_[::-1]
    # analyse: time complexity: O(n); space complexity: O(n)

    def printListFromTailToHead(self, listNode):
        '''第二种解法----递归--easy'''
        ans = []
        if listNode == None:
            return []
        ans.append(listNode.val)
        self.printListFromTailToHead(listNode.next)
        return ans[::-1]
        # analyse: time complexity: O(n); space complexity:O(n)
