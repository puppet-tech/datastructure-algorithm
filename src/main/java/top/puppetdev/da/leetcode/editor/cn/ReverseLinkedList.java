package top.puppetdev.da.leetcode.editor.cn;

import top.puppetdev.da.leetcode.editor.cn.common.ListNode;

/**
 * 题目：206 反转链表
 *
 * @author puppet
 * @since 2023-04-09 22:40:04
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
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
        public ListNode reverseList(ListNode head) {
            ListNode prev = null, cursor = head, next = head;
            while (cursor != null) {
                next = cursor.next;
                cursor.next = prev;
                prev = cursor;
                cursor = next;
            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}