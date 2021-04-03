# coding: utf-8
# 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
# 如果有两个中间结点，则返回第二个中间结点。
# Difficulty: easy
class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        '''double pointer'''
        # 1.如果车同起点同时间同方向匀速行驶，A车速度是 B车一半，那 B车达到终点时，A应该是在 中间
        # 2.定义两个指针，fast和slow，因为有奇偶节点数，所以有两种情况；
        # 3.当fast is None 或 fast.next is None时，fast 到终点，此时 slow 在中间点
        # 4.No boundary conditions
        slow = head
        fast = head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next
        return slow
    # analyse: time complexity is O(n); space complexity is O(1);

