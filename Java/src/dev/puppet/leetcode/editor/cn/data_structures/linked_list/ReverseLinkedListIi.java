package dev.puppet.leetcode.editor.cn.data_structures.linked_list;

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
     * @Tag 迭代、哨兵节点
     * @Solution 穿针引线法之头插法
     * @Tip 1、prev 一直都在 left 前的一个节点
     *         2、succ.next = prev.next 必须先与 prev.next = succ 执行，否则会丢失节点
     *         3、succ.next 必须是指向 prev.next 才是头插
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 这是链表这类题目的常用手法，定义一个哨兵节点，或者称为虚拟节点
            ListNode dummyNode = new ListNode();
            // 将虚拟节点的 next 指向 head，算法的最后只需要返回 dummyNode.next 即可
            dummyNode.next = head;
            ListNode prev = dummyNode;
            // 找到 left 的前一个节点
            for (int i = 0; i < left - 1; i++) {
                prev = prev.next;
            }
            ListNode cur = prev.next;
            ListNode succ = cur.next;
            for (int i = 0; i < right - left; i++) {
                cur.next = succ.next;
                succ.next = prev.next;
                prev.next = succ;
                succ = cur.next;
            }
            return dummyNode.next;
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