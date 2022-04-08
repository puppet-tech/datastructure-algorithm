package dev.puppet.data.structures.linked_list;

import java.time.temporal.Temporal;

/**
 * 回文链表
 * @author puppet
 * @since 2022/4/5 19:14
 */
public class LC234PalindromeLinkedList {
    /**
     * @Tag 链表、快慢指针、链表反转、
     * @Solution 快慢指针
     *         1. 利用快慢指针（慢指针走一步，快指针走两步）找到回文链表的中间结点
     *         2. 对后半部分的链表进行链表反转
     *         3. 将后半部分链表（反转之后的）与前半部分链表进行比较，即可知道结果
     * @Tip 注意事项
     *         1. 如果链表结点数为奇数，则中间结点不需要理会
     *         2. 如果是实际开发，需要注意将被反转部分的链表反转回来，因为我们只是想要判断是否为回文链表，并不希望链表被反转。
     *         3. 如果链表结点数为 1，则直接返回 true
     * @TimeComplexity O(N) —— N 为链表结点数
     * @SpaceComplexity O(1)
     */
    public static boolean solve(ListNode head) {
        // 如果链表结点数量只有 1、2
        if (head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        // 定义快慢指针，注意：如果快慢指针不是从 null 开始，则一开始 fast 就要比 slow 多一个身位
        ListNode slow = head, fast = head.next;
        // 快慢指针开始移动，当移动停止，slow 则为链表的中间结点（注意区分链表结点数量奇偶数时中间结点的不同）
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 对链表后半部分进行链表反转
        // 定义游标指针和前驱指针，
        // 注意游标指针的初始位置为 slow.next，前驱指针的初始位置为 slow（无论链表结点数量为奇数还是偶数）
        ListNode cur = slow.next, prev = slow;
        // 开始进行链表反转
        while (cur != null) {
            // 定义临时指针存储下一个结点
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        // 链表反转完成，进行前后两部分对比
        ListNode leftCur = head, rightCur = prev;
        while (leftCur != slow) {
            // 如果中途比较过程遇到不相等的，则直接返回 false
            if (leftCur.val != rightCur.val) return false;
            // 移动两个游标指针
            leftCur = leftCur.next;
            rightCur = rightCur.next;
        }
        // 比较最后一个结点（无论链表结点数量为奇数还是偶数）
        return leftCur.val == rightCur.val;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode() {
        }
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
