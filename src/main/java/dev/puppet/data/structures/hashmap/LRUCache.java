package dev.puppet.data.structures.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * LC 146：LRU 缓存
 * 该题是实现一个数据结构
 * @author puppet
 * @Tag 哈希表、双向链表
 * @Solution 根据题意和 LRU 缓存机制原理，我们需要完成以下的需求：
 *         1. 通过 get 获取元素时，如果元素不存在，直接返回 -1，否则返回元素，并将元素移动至头部，同时时间复杂度要求为 O(1)
 *         2. 通过 put 添加元素时：
 *         如果元素存在，则更改元素的值，并将元素移至头部；
 *         如果元素不存在，则在头部添加该元素
 *         如果满了，则删除尾部元素，然后再在头部添加元素
 *         同时，该操作的时间复杂度要求为 O(1)
 *         <p>
 *         首选，LRU 缓存就是要用 HashMap 和链表来完成
 *         使用了 HashMap 之后，获取元素的时间复杂度为 O(1)
 *         因为元素之间有顺序关系，所以考虑用链表将元素串联起来，那用单链表行不行？
 *         如果用单链表，那如何将元素移动至头部？答案是不行。用单链表会导致元素的前驱节点丢失。所以只能用双链表。
 *         接着，由于有头部和尾部，我们得用两个指针记录头部和尾部的位置
 *         这样子，结合双链表，我们将元素移动至头部的时间复杂度就是 O(1)，整个 get 操作就是 O(1)
 *         同时，有了头部指针，在头部添加元素也是 O(1)，删除尾部元素也是 O(1)
 *         整个 put 操作就是 O(1)
 *         以上，满足需求
 * @Tip 拓展和注意事项
 *         1. 题目出现 key 和 value，首先想到哈希表
 *         2. 题目中元素有出入顺序，首先想到栈、队列 或 链表
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

