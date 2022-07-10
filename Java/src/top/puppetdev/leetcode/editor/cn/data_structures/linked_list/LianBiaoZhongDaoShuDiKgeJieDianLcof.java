package top.puppetdev.leetcode.editor.cn.data_structures.linked_list;

/**
 * 题目：剑指 Offer 22 链表中倒数第k个节点
 * @author puppet
 * @since 2022-07-08 13:13:41
 */
public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    /**
     * @Classification 链表
     * @Tag 双指针
     * @Solution 1. 定义前后指针，前指针比后指针提前走 k 步
     *         2. 当前指针指向 null 时，则后指针所指向节点即为要找的节点
     * @Tip
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode behind = head, front = head;
            // 前指针先行 k 步
            for (int i = 0; i < k; i++) {
                front = front.next;
            }
            while (front != null) {
                behind = behind.next;
                front = front.next;
            }
            return behind;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}