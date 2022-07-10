package top.puppetdev.leetcode.editor.cn.data_structures.linked_list;

/**
 * 题目：2 两数相加
 * @author puppet
 * @since 2022-07-08 17:04:22
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
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
     * @Tag 数学
     * @Solution
     * @Tip 1. 将两个链表看成等长，不够的用 0 补齐代替
     *         2. 考虑进位问题，由于最大也是 9 + 9，所以进位最多为 1
     *         3. 最后要根据进位的情况，决定需不需要在最终链表的尾部补充最后一个节点
     *         4. 用哨兵节点/虚拟节点辅助，避免头指针丢失
     * @TimeComplexity O(m + n) 两条链表的长度和
     * @SpaceComplexity O(m + n) 两条链表的长度和
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            int x, y, carry = 0, num;
            while (l1 != null || l2 != null) {
                x = l1 == null ? 0 : l1.val;
                y = l2 == null ? 0 : l2.val;

                num = (x + y + carry) % 10;
                cur.next = new ListNode(num);
                cur = cur.next;

                carry = (x + y + carry) / 10;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (carry == 1) cur.next = new ListNode(1);
            return dummy.next;
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