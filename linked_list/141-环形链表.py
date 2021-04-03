# coding: utf-8
# 给定一个链表，判断链表中是否有环。
# 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
# 如果 pos 是 -1，则在该链表中没有环。
# Difficulty: easy
class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        '''hash map'''
        # 1.借助哈希表，遍历整个链表，将节点的地址存入哈希表中
        # 2.每次判断节点地址是否在哈希表中，如果在，则说明已经遍历完一边，遇环回来了
        # 3.如果当前节点为None，则说明遍历完成，没有遇环，为非环形链表
        hash_ = set()
        cur = head
        while cur != None:
            if cur in hash_:
                return True
            else:
                hash_.add(cur)
                cur = cur.next
        return False
    # analyse: time complexity:O(n); space complexity:O(n)

    def hasCycle(self, head: ListNode) -> bool:
        '''double pointer'''
        # 1.类比两个速度不同的人在环形跑道上跑，一个跑得快，一个跑得慢；
        # 2.如果是非环，则跑得快的先到终点，即 fast -> None
        # 3.如果是环，则 slow 与 fast 最终会相遇，可以将 fast 定义在 head.next
        if head == None or head.next == None:
            return False
        slow = head
        fast = head.next
        while slow != fast:
            if fast == None or fast.next == None:
                return False
            else:
                slow = slow.next
                fast = fast.next.next
        return True
    # analyse: time complexity: O(n); space complexity: O(1)










