package top.puppetdev.da.leetcode.editor.cn;

import top.puppetdev.da.leetcode.editor.cn.common.ListNode;

/**
 * 题目：234 回文链表
 *
 * @author puppet
 * @since 2023-04-18 12:37:57
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        solution.isPalindrome(head);
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
    class Solution {
        /**
         * 定义快慢指针 fast 和 slow，定位到中间节点，此时中间节点为 slow
         * 利用中间节点对后半段链表进行反转，反转后 prev 即为后半段的起始节点
         * 遍历对比前半段链表和反转后的后半段链表即可得出答案
         *
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            ListNode dummy = new ListNode(), fast = dummy, slow = dummy;
            dummy.next = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            // make truncation
            ListNode startingPointOfTheSecondHalf = slow.next;
            slow.next = null;
            // reverse the linked list
            ListNode cursor = startingPointOfTheSecondHalf, prev = null, next = null;
            while (cursor != null) {
                next = cursor.next;
                cursor.next = prev;
                prev = cursor;
                cursor = next;
            }
            // start to traverse the two linked list
            while (head != null && prev != null) {
                if (head.val != prev.val) return false;
                head = head.next;
                prev = prev.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}