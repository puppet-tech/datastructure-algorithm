package top.puppetdev.da.leetcode.editor.cn.data_structures.linked_list;

/**
 * 题目：19 删除链表的倒数第 N 个结点
 * @author puppet
 * @since 2022-07-08 14:12:07
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
     * @Tag 多指针
     * @Solution 该题核心思路分为两步：
     *         1. 找到要删除的节点，根据题意，可以通过前后指针找到
     *         2. 删除该节点，由于删除该节点需要知道前驱节点，所以在第一步的时候，可以再多一个指针指向待删除节点的前驱指针
     * @Tip 使用哨兵节点/虚拟节点，可以更好地处理边界条件
     * @TimeComplexity O(N) 只需要遍历一次就可以知道待删除的节点及其前驱节点
     * @SpaceComplexity O(1) 常量个指针数量
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyNode = new ListNode();
            dummyNode.next = head;
            ListNode prev = dummyNode, behind = head, front = head;
            // front 先走 n 步
            for (int i = 0; i < n; i++) {
                front = front.next;
            }
            // 当遍历结束后，behind 指向即为待删除节点，prev 即为待删除节点的前驱节点
            while (front != null) {
                prev = prev.next;
                behind = behind.next;
                front = front.next;
            }
            // 删除节点
            prev.next = behind.next;
            return dummyNode.next;
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