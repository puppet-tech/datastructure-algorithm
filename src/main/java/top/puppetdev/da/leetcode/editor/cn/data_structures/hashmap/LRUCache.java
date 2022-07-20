package top.puppetdev.da.leetcode.editor.cn.data_structures.hashmap;

import java.util.HashMap;

/**
 * LC 146：LRU 缓存
 * 该题是实现一个数据结构
 * @author puppet
 * @Tag 哈希表、双向链表
 * @Solution
 * @Tip 拓展和注意事项
 * @since 2022/3/31 21:32
 */
public class LRUCache {
    /**
     * 自定义双向链表
     */
    class DLinkedListNode {
        private int key;  // 之所以需要 key，只因为需要通过结点删除存储 HashMap 中的元素，其他情况不需要用到
        private int value;
        private DLinkedListNode prev;
        private DLinkedListNode next;
        
        public DLinkedListNode() {
        }
        
        public DLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private HashMap<Integer, DLinkedListNode> cache = new HashMap<>();
    private int capacity;
    private int size = 0;
    
    /**
     * 哨兵结点
     */
    private DLinkedListNode head = new DLinkedListNode();
    private DLinkedListNode tail = new DLinkedListNode();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        DLinkedListNode result = cache.get(key);
        if (result != null) {
            moveToHead(result);
            return result.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        DLinkedListNode result = cache.get(key);
        // 如果结点已经存在，则更新值，然后直接返回
        if (result != null) {
            result.value = value;
            moveToHead(result);
            return;
        }
        // 如果结点不存在，则插入
        // 如果缓存器容量已满
        if (this.size >= this.capacity) {
            // 注意：这里得先将元素从 cache 中删除，再去 removeTail，因为 removeTail 会改变 this.tail.prev
            cache.remove(this.tail.prev.key);
            removeTail();
            size--;
        }
        DLinkedListNode newNode = new DLinkedListNode(key, value);
        cache.put(key, newNode);
        addToHead(newNode);
        size++;
    }
    
    private void removeTail() {
        removeNode(this.tail.prev);
    }
    
    private void moveToHead(DLinkedListNode node) {
        removeNode(node);
        addToHead(node);
        
    }
    
    private void addToHead(DLinkedListNode node) {
        this.head.next.prev = node;
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next = node;
    }
    
    private void removeNode(DLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        lruCache.get(1);
        lruCache.get(2);
    }
}

