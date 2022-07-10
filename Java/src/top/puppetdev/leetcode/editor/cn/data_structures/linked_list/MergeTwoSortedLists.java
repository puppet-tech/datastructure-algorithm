package top.puppetdev.leetcode.editor.cn.data_structures.linked_list;

/**
 * 题目：21 合并两个有序链表
 * @author puppet
 * @since 2022-07-10 10:44:16
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
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
     * @Tag 哨兵节点/虚拟节点，双指针
     * @Solution 穿针引线法
     *         1. 返回的是链表的头结点，考虑用哨兵结点简化操作，并避免头结点丢失
     *         2. 定义游标指针 cur，初始状态下，游标指针指向哨兵结点
     *         3. 进行迭代，两两比较 list1.val 和 list2.val，将值较小的结点，利用游标指针串联起来，然后更新 cur、list1 和 list 2
     *         4. 最后遍历完，如果存在某条链表有剩余结点，则进行判断后，直接连接到结果链表的最后线
     * @Tip 游标要记得移动
     * @TimeComplexity O(M + N)  m 和 n 分别为两条链表的长度
     * @SpaceComplexity O(1) 常量数个指针
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummyNode = new ListNode();
            ListNode cur = dummyNode;
            // 当 list1 和 list2 都不为 null 时，进行比较，然后将较小的串起来
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                // 游标要记得移动
                cur = cur.next;
            }
            // 当 list1 或 list2 其中一个指向 null 时，则将另一条还没遍历完的部分补到末尾
            if (list1 != null) cur.next = list1;
            if (list2 != null) cur.next = list2;
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