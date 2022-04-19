package dev.puppet.data_structures.linked_list;

/**
 * 两数相加
 * @author puppet
 * @since 2022/3/19 22:12
 */
public class LC2AddTwoNumbers {
    /**
     * @Tag 链表、预先指针
     * @Solution 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 00，比如 987 + 23 = 987 + 023 = 1010
     *         每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
     *         如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11
     * @Tip 对于链表问题，返回结果为头结点时，通常可以借助哨兵结点（预先指针guard.next）guard，该指针的下一个节点指向真正的头结点 head。
     *         使用哨兵结点的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    public ListNode solve(ListNode l1, ListNode l2) {
        // 定义哨兵结点，避免最后头指针丢失。
        ListNode guard = new ListNode(0);
        // 游标指针
        ListNode cur = guard;
        // 进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            // 可以把 carry = sum / 10; 换成 carry = sum > 9 ? 1 : 0;
            // 因为两个数最大是 9 + 9 + 1，进位最多为 1，另外比较运算符比算术运算符的效率要高，所以可以这样子做
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            // 判空，避免出现空指针异常
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 最后如果进位 carry 为 1，则最后需要新增一个值为 1 的节点
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        // 返回头结点，哨兵结点的 next 即为头结点
        return guard.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


