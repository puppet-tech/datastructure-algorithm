package leetcode.editor.cn.data_structures.linked_list;

/**
 * 单链表反转
 * @author puppet
 * @since 2022/2/2 8:21 下午
 */
public class LC206ReverseLinkedList {
    /**
     * @Tag 链表
     * @Solution 迭代解法
     *         假设链表为 1 -> 2 -> 3 -> null，我们想要把它改成 null <- 1 <- 2 <- 3
     *         在遍历链表时，将当前节点的 next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
     *         在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
     * @Tip 一般来说，如果返回值是链表的头节点，我们大多会采用哨兵节点来进行辅助。但是链表反转不同，所以不需要借助哨兵节点。
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    public ListNode solve(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTmp;
        }
        return prev;
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
