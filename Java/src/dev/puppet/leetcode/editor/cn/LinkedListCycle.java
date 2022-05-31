package dev.puppet.leetcode.editor.cn;

/**
 * 题目：141 环形链表
 * @author puppet
 * @since 2022-05-31 16:26:35
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    /**
     * @Tag 快慢指针
     * @Solution 根据 Floyd 判圈算法（兔龟赛跑算法），我们可以设置快慢指针，
     *         如果没有环，则快指针会一直在慢指针的前面，两者决不会相遇，直到走到终点
     *         相反，如果存在环，则快慢指针必然会有相遇的时刻
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            // 如果链表没有节点或只有一个节点时
            if (head == null || head.next == null) return false;
            
            // 定义快慢指针，一开始均指向 head 节点
            ListNode fast = head, slow = head;
            do {
                fast = fast.next.next;
                slow = slow.next;
                // 如果快慢节点相遇了，说明存在环
                if (fast == slow) return true;
            } while (slow != null && fast != null && fast.next != null);
            // 如果走到终点，说明没有环
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
    
    class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
}