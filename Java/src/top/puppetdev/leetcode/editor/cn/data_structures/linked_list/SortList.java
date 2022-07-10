package top.puppetdev.leetcode.editor.cn.data_structures.linked_list;

/**
 * 题目：148 排序链表
 * @author puppet
 * @since 2022-07-08 20:32:50
 */
public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
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
     * @Tag 分治思想（归并排序）、双指针、递归
     * @Solution 自顶向下归并排序
     *         1. 通过快慢指针的技巧找到链表的中点，将链表分为两个部分
     *         2. 分别对两个部分进行递归排序，得到两个有序链表
     *         3. 将两个有序链表进行合并
     *         上述的步骤使用递归实现，递归的终止条件为，当子链表只有一个节点或者为 null 时
     * @Tip 注意在找链表中点的时候，需要将链表截成两段，否则会有问题
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(nlogn) 递归栈
     */
    class Solution {
        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        private ListNode sortList(ListNode head, ListNode tail) {
            // 递归终止条件
            if (head == null || head.next == null) return head;

            // 找到链表中点，但需要注意的是，使得链表分为两截
            ListNode mid = getMiddle(head);
            // 截成两段之前，先将下一个节点给保存起来
            ListNode temp = mid.next;
            mid.next = null;

            // 分别对两部分链表进行排序
            ListNode list1 = sortList(head, mid);
            ListNode list2 = sortList(temp, tail);
            // 合并两个有序链表，然后将头节点返回
            return mergeList(list1, list2);
        }

        private ListNode mergeList(ListNode list1, ListNode list2) {
            ListNode dummyNode = new ListNode();
            ListNode cur = dummyNode;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            if (list1 != null) cur.next = list1;
            if (list2 != null) cur.next = list2;
            return dummyNode.next;
        }

        private ListNode getMiddle(ListNode head) {
            ListNode dummyNode = new ListNode();
            dummyNode.next = head;
            ListNode slow = dummyNode, fast = dummyNode;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
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