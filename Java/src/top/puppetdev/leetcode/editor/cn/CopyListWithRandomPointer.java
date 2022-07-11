package top.puppetdev.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：138 复制带随机指针的链表
 * @author puppet
 * @since 2022-05-31 16:24:56
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
    
    /**
     * @Classification 链表
     * @Tag 回溯、散列表、递归
     * @Solution 回溯+散列表
     *         如果是普通的链表，可以直接遍历拷贝，但由于多了随机指针，所以拷贝的时候指针指向的节点可能尚未被创建
     *         这种情况可以借助回溯思想，当遇到节点尚未创建的情况，则递归先将该节点拷贝创建出来
     *         需要注意，已经创建的节点则用哈希表缓存起来
     * @TimeComplexity O(N)  整个链表的节点数量
     * @SpaceComplexity O(N) 哈希表的大小
     */
    class Solution {
        // 散列表
        Map<Node, Node> cachedNodeMap = new HashMap<>();
        
        public Node copyRandomList(Node head) {
            // 递归终止条件
            if (head == null) return null;
            // 如果当前节点还没有被缓存到 map 中，说明当前节点还没有被拷贝
            if (!cachedNodeMap.containsKey(head)) {
                // 拷贝当前节点
                Node newNode = new Node(head.val);
                // 将当前节点加入缓存，避免再次拷贝
                cachedNodeMap.put(head, newNode);
                // 拷贝当前节点的 next 和 random 指针指向的节点
                newNode.next = copyRandomList(head.next);
                newNode.random = copyRandomList(head.random);
            }
            // 返回当前节点
            return cachedNodeMap.get(head);
        }
    }
    
    //leetcode submit region end(Prohibit modification and deletion)
    class Node {
        int val;
        Node next;
        Node random;
        
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}