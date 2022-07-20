package top.puppetdev.da.leetcode.editor.cn.common;

/**
 * @author puppet
 * @since 2022/7/20 18:20
 */
public class DLinkedListNode {
    
    /** 之所以需要 key，只因为需要通过结点删除存储 HashMap 中的元素，其他情况不需要用到 */
    public int key;
    
    public int value;
    public DLinkedListNode prev;
    public DLinkedListNode next;
    
    public DLinkedListNode() {
    }
    
    public DLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
