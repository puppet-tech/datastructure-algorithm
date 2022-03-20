package org.example.linked_list;

/**
 * LC 2：两数相加
 *
 * @author puppet
 * @since 2022/3/19 22:12
 */
public class Q2AddTwoNumbers {
    /**
     * 链表、预先指针
     * 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 00，比如 987 + 23 = 987 + 023 = 1010
     * 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
     * 如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11
     * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solve(ListNode l1, ListNode l2) {
        // 定义一个预先指针，避免最后头指针丢失。
        ListNode pre = new ListNode(0);
        // 游标指针
        ListNode cur = pre;
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
        // 返回头节点，预先指针的 pre 即为头节点
        return pre.next;
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


