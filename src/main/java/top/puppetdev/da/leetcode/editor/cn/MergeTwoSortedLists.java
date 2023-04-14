package top.puppetdev.da.leetcode.editor.cn;

/**
 * 题目：21 合并两个有序链表
 *
 * @author puppet
 * @since 2023-04-14 14:24:49
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
    class Solution {
        /**
         * 定义一个哨兵节点（伪节点dummyNode）和一个游标节点（cursor)
         * 哨兵节点的作用是避免头节点丢失，游标节点是为了避免进行节点拼接时，下一个节点丢失
         * 两条链表的节点进行迭代比较，对于较小的节点，则用 cursor.next = list1||list2穿起来，然后移动 list = list.next
         * 当 list1 == null 或 list2 ==null，则遍历结束，将尚未遍历完的拼接到最后cursor.next = list1 || list2
         * 最后返回 dummyNode.next
         *
         * @param list1
         * @param list2
         * @return
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummyNode = new ListNode();
            ListNode cursor = dummyNode;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cursor.next = list1;
                    list1 = list1.next;
                } else {
                    cursor.next = list2;
                    list2 = list2.next;
                }
                cursor = cursor.next;
            }
            if (list1 != null) cursor.next = list1;
            if (list2 != null) cursor.next = list2;
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
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }