package dev.puppet.data_structures.linked_list;

/**
 * 合并两个有序列表
 * @author puppet
 * @since 2022/3/29 10:35
 */
public class LC21MergeTwoSortedLists {
    /**
     * @Tag 链表、双指针、哨兵结点
     * @Solution 迭代解法
     *         1. 返回的是链表的头结点，考虑用哨兵结点简化操作，并避免头结点丢失
     *         2. 定义游标指针 cur，初始状态下，游标指针指向哨兵结点
     *         3. 进行迭代，两两比较 list1.val 和 list2.val，将值较小的结点，利用游标指针串联起来，然后更新 cur、list1 和 list 2
     *         4. 最后遍历完，如果存在某条链表有剩余结点，则进行判断后，直接连接到结果链表的最后
     * @Tip 注意边界条件
     *         1. 当 list1 或 list2 为空时，直接返回不为空的那条链表：实际上，下面的代码已经包含了该边界条件，不需要改动
     * @TimeComplexity O(m + n) —— m 和 n 分别为两条链表的长度
     * @SpaceComplexity O(1) —— 只用到了哨兵结点和游标指针等常量级额外内存
     */
    public static ListNode solve(ListNode list1, ListNode list2) {
        // 定义哨兵结点和游标指针，一开始，游标指针指向哨兵结点
        ListNode guard = new ListNode(0);
        ListNode cur = guard;

        // 进入遍历，当 list1 和 list2 均不为 null 时，进行两两比较，拼接到结果链表中
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // 先把值较小的结点连接起来：cur.next = list1
                cur.next = list1;
                // 再移动游标指针 cur 和遍历指针 list1
                cur = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            }
        }
        // 当遍历结束后，如果存在剩余结点，则将剩余的结点连接到最后
        if (list1 != null) cur.next = list1;
        if (list2 != null) cur.next = list2;
        // 返回整条链表的头结点：即哨兵结点的 next
        return guard.next;
    }

    public static class ListNode {
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
