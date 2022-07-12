package top.puppetdev.da.leetcode.editor.cn.data_structures.linked_list;

import top.puppetdev.da.leetcode.editor.cn.common.CommonUtils;
import top.puppetdev.da.leetcode.editor.cn.common.ListNode;

/**
 * 题目：24 两两交换链表中的节点
 * @author puppet
 * @since 2022-07-11 12:42:16
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        int[] nums = {1, 2, 3};
        ListNode list = CommonUtils.parseIntArrayIntoLinkedList(nums);
        solution.swapPairs(list);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    /**
     * @Classification 链表
     * @Tag 双指针
     * @Solution 借助“链表反转II”中的头插法的思想：将链表中的某个节点移动到 prev 的后面
     *         需要注意：
     *         1. 节点为奇数个的时候，最后一个节点不需要交换，此时 cur.next == null，
     *         因此循环条件要设置为cur != null && cur.next != null
     *         2. 需要先处理掉没有节点或节点数只有一个的情况
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            // 处理边界条件：如果链表没有节点或只有一个节点时
            if (head == null || head.next == null) return head;
            
            // 借助虚拟节点，更好处理边界条件：即只需要处理没有节点或只有一个节点的情况
            ListNode dummy = new ListNode();
            dummy.next = head;
            
            ListNode prev = dummy, cur = head, succ = head.next;
            
            while (cur != null && cur.next != null) {
                cur.next = succ.next;
                succ.next = prev.next;
                prev.next = succ;
                // 交换节点位置后，更新指针位置
                succ = cur.next;
                prev = cur;
                cur = cur.next;
                if (cur != null) succ = cur.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
    
}