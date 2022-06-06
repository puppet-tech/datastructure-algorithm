package dev.puppet.leetcode.editor.cn;

/**
 * 题目：160 相交链表
 * @author puppet
 * @since 2022-06-06 09:15:17
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    /**
     * @Classification 链表
     * @Tag 链表、双指针
     * @Solution 双指针
     * @TimeComplexity O(M + N) 两个链表的长度和
     * @SpaceComplexity O(1)
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = headA, pB = headB;
            // 一直循环，直到两个指针相等
            while (pA != pB) {
                // 如果不为 null，则往下走，如果为 null，则直接跳到另一条链表上
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
    }
    
    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}