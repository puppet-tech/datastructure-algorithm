# coding:utf-8
# 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
# Difficulty: easy
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        '''recursion'''
        # 使用递归，操作头结点
        # 1.如果两条链表存在一条为空，则直接return l1 or l2返回其中一条不为空的链表
        # 2.如果两条链表都不为空，则判断了l1链表的头结点中的val是否比l2的小
        # 如果比l2的大，则交换l1和l2的引用指向，把l1的头结点的val值确定为最小的
        # 3.使用递归，调用函数本身，将l1.next和l2传入，然后将返回值用l1.next接住，串起来
        if l1 and l2:
            if l1.val < l2:
                l1.next = self.mergeTwoLists(l1.next, l2)
        return l1 or l2
