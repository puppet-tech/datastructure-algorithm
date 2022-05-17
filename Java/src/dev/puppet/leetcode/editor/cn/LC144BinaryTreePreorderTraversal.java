  //<p>给你二叉树的根节点 <code>root</code> ，返回它节点值的 <strong>前序</strong><em> </em>遍历。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg" style="width: 202px; height: 324px;" />
//<pre>
//<strong>输入：</strong>root = [1,null,2,3]
//<strong>输出：</strong>[1,2,3]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = []
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>root = [1]
//<strong>输出：</strong>[1]
//</pre>
//
//<p><strong>示例 4：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_5.jpg" style="width: 202px; height: 202px;" />
//<pre>
//<strong>输入：</strong>root = [1,2]
//<strong>输出：</strong>[1,2]
//</pre>
//
//<p><strong>示例 5：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_4.jpg" style="width: 202px; height: 202px;" />
//<pre>
//<strong>输入：</strong>root = [1,null,2]
//<strong>输出：</strong>[1,2]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>树中节点数目在范围 <code>[0, 100]</code> 内</li>
//	<li><code>-100 <= Node.val <= 100</code></li>
//</ul>
//
//<p> </p>
//
//<p><strong>进阶：</strong>递归算法很简单，你可以通过迭代算法完成吗？</p>
//<div><div>Related Topics</div><div><li>栈</li><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 826</li><li>👎 0</li></div>
  
  package dev.puppet.leetcode.editor.cn;
  public class LC144BinaryTreePreorderTraversal{
      public static void main(String[] args) {
           Solution solution = new LC144BinaryTreePreorderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }