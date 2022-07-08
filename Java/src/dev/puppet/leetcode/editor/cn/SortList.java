package dev.puppet.leetcode.editor.cn;

/**
 * 题目：148 排序链表
 * @author puppet
 * @since 2022-07-08 20:32:50
 */
public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
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
        public ListNode sortList(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            val = val;
        }
    }


}