package dev.puppet.leetcode.editor.cn;

/**
 * 题目：92 反转链表 II
 * @author puppet
 * @since 2022-06-06 21:28:05
 */
public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
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
     * @Tag
     * @Solution
     * @Tip
     * @TimeComplexity
     * @SpaceComplexity
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode cur = head;
            return cur;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}