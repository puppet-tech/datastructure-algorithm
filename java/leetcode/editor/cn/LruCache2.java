package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 题目：146 LRU 缓存
 *
 * @author puppet
 * @since 2023-04-09 02:08:53
 */
public class LruCache2 {
    //    public static void main(String[] args) {
//        Solution solution = new LruCache().new Solution();
//    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private int size;
        private int capacity;
        private DLinkedListNode dummyHead;
        private DLinkedListNode dummyTail;
        private HashMap<Integer, DLinkedListNode> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.cache = new HashMap<>();
            this.dummyHead = new DLinkedListNode();
            this.dummyTail = new DLinkedListNode();
            this.dummyHead.next = this.dummyTail;
            this.dummyTail.prev = this.dummyHead;
        }

        public int get(int key) {
            DLinkedListNode node = cache.get(key);
            if (node == null) return -1;
            this.moveToHead(node);
            return node.value;
        }

        private void moveToHead(DLinkedListNode node) {
            this.removeNode(node);
            this.addToHead(node);
        }

        private void addToHead(DLinkedListNode node) {
            node.prev = this.dummyHead;
            node.next = this.dummyHead.next;
            this.dummyHead.next.prev = node;
            this.dummyHead.next = node;
        }

        private void removeNode(DLinkedListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void put(int key, int value) {
            DLinkedListNode node = this.cache.get(key);
            if (node != null) {
                node.value = value;
                this.moveToHead(node);
            } else {
                // otherwise, the node is null
                DLinkedListNode newNode = new DLinkedListNode(key, value);
                cache.put(key, newNode);
                this.addToHead(newNode);
                size++;
                if (size > capacity) {
                    this.cache.remove(this.dummyTail.prev.key);
                    this.removeNode(this.dummyTail.prev);
                    this.size--;
                }
            }
        }
    }

    class DLinkedListNode {
        int value;
        int key;
        DLinkedListNode prev;
        DLinkedListNode next;

        public DLinkedListNode() {
        }

        public DLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
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