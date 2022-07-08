package dev.puppet.leetcode.editor.cn;

/**
 * 题目：143 重排链表
 * @author puppet
 * @since 2022-07-08 00:42:47
 */
public class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /**
     * @Classification 链表
     * @Tag 双指针
     * @Solution 链表中点 + 反转链表 + 链表合并
     *         根据题意，目标链表其实是：原始链表的前半段 + 原始链表后半段的反转
     *         所以我们可以分为三步：
     *         1. 利用双指针找到链表的中点
     *         2. 反转后半段链表
     *         3. 合并前后两段链表，由于两段链表节点数相差不超过一个，所以可以直接合并
     * @Tip 1. 需要手动将链表截成两段，否则可能会出现环
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    class Solution {
        public void reorderList(ListNode head) {
            if (head.next == null || head.next.next == null) return;
            ListNode middle = findMiddleNode(head);
            ListNode l1 = head;
            ListNode l2 = reverse(middle.next);
            // 将链表截断为两个部分，否则会出现环
            middle.next = null;
            // 将两个部分合并到一块
            merge(l1, l2);
        }

        private void merge(ListNode l1, ListNode l2) {
            ListNode l1Temp, l2Temp;
            while (l1 != null && l2 != null) {
                l1Temp = l1.next;
                l2Temp = l2.next;
                l1.next = l2;
                l2.next = l1Temp;
                l1 = l1Temp;
                l2 = l2Temp;
            }
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            ListNode temp;
            while (cur != null) {
                temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            return prev;
        }

        private ListNode findMiddleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
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