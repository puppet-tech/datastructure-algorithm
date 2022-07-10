package dev.puppet.leetcode.editor.cn;

/**
 * 题目：234 回文链表
 * @author puppet
 * @since 2022-07-10 23:37:01
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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
     * @Solution 链表中点+链表反转
     *         1. 先用快慢指针找到链表中点
     *         2. 链表中点将链表分为两段，将后半段进行反转
     *         3. 比较两段的值，由此即可判断是否为回文链表
     * @Tip
     * @TimeComplexity O(N) 需要遍历 3 次，但依然是 O(N)
     * @SpaceComplexity O(1) 只需常量个指针
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {

            return false;
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