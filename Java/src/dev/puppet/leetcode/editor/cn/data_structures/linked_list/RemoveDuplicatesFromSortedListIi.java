package dev.puppet.leetcode.editor.cn.data_structures.linked_list;

/**
 * 题目：82 删除排序链表中的重复元素 II
 * @author puppet
 * @since 2022-07-08 14:52:28
 */
public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
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
     * @Solution 左右指针
     *         1. 定义左右两个指针，间隔一个节点，同时需要一个前驱节点，用来删除节点
     *         2. 遍历整个链表，每次比较左右两个指针的值，如果相同，则将右指针右移一个节点，并将 flag 置为 true
     *         如果不同，则又分为两种情况：
     *         ① flag 为真，说明前面有重复节点，则将所有节点删除，并将 flag 置为假
     *         ② flag 为假，说明前面没有重复节点，则将 prev、left 和 right 整体移动一个节点
     *         3. 直到右指针指向 null，遍历结束
     *         4. 最后，如果 flag 保留为真，说明前面还有重复节点需要删除，则直接删除
     * @Tip 1. 使用哨兵节点/虚拟节点，可以更好地处理边界条件
     *         2. 注意题意是要删除所有重复的节点
     * @TimeComplexity O(N) 遍历一次链表
     * @SpaceComplexity O(1) 常量个指针
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 当链表没有节点或者只有一个节点时
            if (head == null || head.next == null) return head;
            // 定义哨兵节点进行辅助
            ListNode dummyNode = new ListNode();
            dummyNode.next = head;

            // 定义左右指针
            ListNode prev = dummyNode, left = head, right = head.next;
            boolean flag = false;

            while (right != null) {
                if (left.val != right.val) {
                    if (flag) {
                        prev.next = right;
                        left = right;
                        right = right.next;
                        flag = false;
                    } else {
                        left = left.next;
                        prev = prev.next;
                        right = right.next;
                    }
                } else {
                    right = right.next;
                    flag = true;
                }
            }
            if (flag) {
                prev.next = right;
            }
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