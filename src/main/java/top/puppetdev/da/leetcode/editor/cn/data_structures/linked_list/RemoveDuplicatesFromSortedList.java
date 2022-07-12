package top.puppetdev.da.leetcode.editor.cn.data_structures.linked_list;

/**
 * 题目：83 删除排序链表中的重复元素
 * @author puppet
 * @since 2022-07-11 10:41:21
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
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
     * @Solution 迭代+左右指针
     *         1. 定义左右指针
     *         2. 遍历，比较左右指针指向节点的值是否相同，如果相同，则将右节点删除，并更新更新右指针
     *         如果不相同，则同时更新左右指针
     *         3. 当右指针指向 null 时，迭代遍历结束
     *         注意考虑边界条件，当链表没有节点或只有一个节点时，直接返回即可
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 如果链表没有节点，或者只有一个节点时，直接返回
            if (head == null || head.next == null) return head;
            
            ListNode left = head, right = head.next;
            
            while (right != null) {
                if (left.val != right.val) left = left.next;
                    // 如果遇到相等的，则直接删除右边的节点
                else left.next = right.next;
                right = right.next;
            }
            return head;
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