package top.puppetdev.leetcode.editor.cn.common;

/**
 * @author puppet
 * @since 2022/7/11 14:20
 */
public class CommonUtils {
    /**
     * 将数组转换成链表
     * @param nums
     * @return
     */
    public static ListNode parseIntArrayIntoLinkedList(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummy.next;
    }
}
