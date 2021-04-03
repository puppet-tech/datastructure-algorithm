# coding: utf-8
# 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
# 给定的 n 保证是有效的。
# 你能尝试使用一趟扫描实现吗？
# Difficulty: medium
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        '''double pointer'''
        # 1.Define two pointers, "prev" and "cur". Let "cur" go n steps first
        # 2.and "prev" and "cur" go together.
        # 3.Let "prev.next" point to "cur" when the "cur.next" is None
        # 4.border case: n == 1, the last node will be deleted; the head node will be deleted;
        if head.next == None:  # if only one node
            return None
        # Define two pointers
        cur = head
        prev = head
        for i in range(n):
            cur = cur.next
        # after "cur" goes n steps, "cur" is None. that will be the head node will be deleted
        if cur == None:
            head = head.next
            return head
        while cur.next != None:
            prev = prev.next
            cur = cur.next
        prev.next = prev.next.next
        return head
    # analyse: time complexity: O(n); space complexity: O(1)









