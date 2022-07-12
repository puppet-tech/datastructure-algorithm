package top.puppetdev.da.leetcode.editor.cn.data_structures.linked_list;

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
     *         1. 先用快慢指针找到链表中点，注意需要用虚拟节点作为快慢指针的起始节点，具体为什么，可以用奇偶数节点进行推断
     *         2. 链表中点将链表分为两段，将后半段进行反转
     *         3. 比较两段的值，由此即可判断是否为回文链表
     * @Tip 如果是奇数个节点，则最后一个节点不需要比较。同时，由于取了链表中点，所以最多也只会剩下一个节点
     * @TimeComplexity O(N) 需要遍历 3 次，但依然是 O(N)
     * @SpaceComplexity O(1) 只需常量个指针
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            // 获取链表中点
            ListNode mid = getMiddle(head);
            // 将链表截断
            ListNode temp = mid.next;
            mid.next = null;
            // 反转链表后半段
            ListNode reversedList = reverseList(temp);
            // 对前后半段进行比较
            while (head != null && reversedList != null) {
                if (head.val != reversedList.val) return false;
                head = head.next;
                reversedList = reversedList.next;
            }
            // 如果遍历后都是符合的，则说明为回文链表，直接返回 true
            return true;
        }
        
        private ListNode reverseList(ListNode head) {
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
        
        private ListNode getMiddle(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode slow = dummy, fast = dummy;
            while (fast != null && fast.next != null) {
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
            val = val;
        }
    }
    
    
}