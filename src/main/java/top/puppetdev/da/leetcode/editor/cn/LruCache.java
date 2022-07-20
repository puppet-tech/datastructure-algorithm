package top.puppetdev.da.leetcode.editor.cn;

/**
 * 题目：146 LRU 缓存
 * @author puppet
 * @since 2022-07-20 18:22:10
 */
public class LruCache {
    // public static void main(String[] args) {
    //     Solution solution = new LruCache().new Solution();
    // }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * 根据题意和 LRU 缓存机制原理，我们需要完成以下的需求：
     * 1. 通过 get 获取元素时，如果元素不存在，直接返回 -1，否则返回元素，并将元素移动至头部，同时时间复杂度要求为 O(1)
     * 2. 通过 put 添加元素时：
     * 如果元素存在，则更改元素的值，并将元素移至头部；
     * 如果元素不存在，则在头部添加该元素
     * 如果满了，则删除尾部元素，然后再在头部添加元素
     * 同时，该操作的时间复杂度要求为 O(1)
     * <p>
     * 首选，LRU 缓存就是要用 HashMap 和链表来完成
     * 使用了 HashMap 之后，获取元素的时间复杂度为 O(1)
     * 因为元素之间有顺序关系，所以考虑用链表将元素串联起来，那用单链表行不行？
     * 如果用单链表，那如何将元素移动至头部？答案是不行。用单链表会导致元素的前驱节点丢失。所以只能用双链表。
     * 接着，由于有头部和尾部，我们得用两个指针记录头部和尾部的位置
     * 这样子，结合双链表，我们将元素移动至头部的时间复杂度就是 O(1)，整个 get 操作就是 O(1)
     * 同时，有了头部指针，在头部添加元素也是 O(1)，删除尾部元素也是 O(1)
     * 整个 put 操作就是 O(1)
     * 以上，满足需求
     * <p>
     * 拓展：
     * 1.  题目出现 key 和 value，首先想到哈希表
     * 2. 题目中元素有出入顺序，首先想到栈、队列 或 链表
     * @TimeComplexity
     * @SpaceComplexity
     * @Classification hashmap
     * @Tag hashmap, linked list
     */
    class LRUCache {
        
        public LRUCache(int capacity) {
        
        }
        
        public int get(int key) {
        
        }
        
        public void put(int key, int value) {
        
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}