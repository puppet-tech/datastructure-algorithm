package org.example.linked_list;

/**
 * LeetCode 206：单链表反转
 * @author puppet
 * @since 2022/2/2 8:21 下午
 */
public class Q206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        /*
            思路：
            假设链表为 1 -> 2 -> 3 -> null，我们想要把它改成 null <- 1 <- 2 <- 3
            在遍历链表时，将当前节点的 next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
            在更改引用之前，还需要存储后一个节点。最后返回新的头引用。

            算法分析：
                时间复杂度：O(N)
                空间复杂度：O(1)
         */
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTmp = head.next;
            cur.next = prev;
            prev = cur;
            cur = nextTmp;
        }
        return prev;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
