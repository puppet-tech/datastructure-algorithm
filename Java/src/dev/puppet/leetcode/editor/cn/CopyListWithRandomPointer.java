//<p>给你一个长度为 <code>n</code> 的链表，每个节点包含一个额外增加的随机指针 <code>random</code> ，该指针可以指向链表中的任何节点或空节点。</p>
//
//<p>构造这个链表的&nbsp;<strong><a href="https://baike.baidu.com/item/深拷贝/22785317?fr=aladdin" target="_blank">深拷贝</a></strong>。&nbsp;深拷贝应该正好由 <code>n</code> 个 <strong>全新</strong> 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 <code>next</code> 指针和 <code>random</code> 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。<strong>复制链表中的指针都不应指向原链表中的节点 </strong>。</p>
//
//<p>例如，如果原链表中有 <code>X</code> 和 <code>Y</code> 两个节点，其中 <code>X.random --&gt; Y</code> 。那么在复制链表中对应的两个节点 <code>x</code> 和 <code>y</code> ，同样有 <code>x.random --&gt; y</code> 。</p>
//
//<p>返回复制链表的头节点。</p>
//
//<p>用一个由&nbsp;<code>n</code>&nbsp;个节点组成的链表来表示输入/输出中的链表。每个节点用一个&nbsp;<code>[val, random_index]</code>&nbsp;表示：</p>
//
//<ul>
//	<li><code>val</code>：一个表示&nbsp;<code>Node.val</code>&nbsp;的整数。</li>
//	<li><code>random_index</code>：随机指针指向的节点索引（范围从&nbsp;<code>0</code>&nbsp;到&nbsp;<code>n-1</code>）；如果不指向任何节点，则为&nbsp;&nbsp;<code>null</code>&nbsp;。</li>
//</ul>
//
//<p>你的代码 <strong>只</strong> 接受原链表的头节点 <code>head</code> 作为传入参数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e1.png" style="height: 142px; width: 700px;" /></p>
//
//<pre>
//<strong>输入：</strong>head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//<strong>输出：</strong>[[7,null],[13,0],[11,4],[10,2],[1,0]]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e2.png" style="height: 114px; width: 700px;" /></p>
//
//<pre>
//<strong>输入：</strong>head = [[1,1],[2,1]]
//<strong>输出：</strong>[[1,1],[2,1]]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/01/09/e3.png" style="height: 122px; width: 700px;" /></strong></p>
//
//<pre>
//<strong>输入：</strong>head = [[3,null],[3,0],[3,null]]
//<strong>输出：</strong>[[3,null],[3,0],[3,null]]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>0 &lt;= n &lt;= 1000</code><meta charset="UTF-8" /></li>
//	<li><code>-10<sup>4</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>4</sup></code></li>
//	<li><code>Node.random</code>&nbsp;为&nbsp;<code>null</code> 或指向链表中的节点。</li>
//</ul>
//<div><div>Related Topics</div><div><li>哈希表</li><li>链表</li></div></div><br><div><li>👍 861</li><li>👎 0</li></div>

package dev.puppet.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表
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