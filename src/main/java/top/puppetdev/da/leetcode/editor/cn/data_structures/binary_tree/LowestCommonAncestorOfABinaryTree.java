package top.puppetdev.da.leetcode.editor.cn.data_structures.binary_tree;

import top.puppetdev.da.leetcode.editor.cn.common.TreeNode;

/**
 * 题目：236 二叉树的最近公共祖先
 * @author puppet
 * @since 2022-07-17 22:38:49
 */
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    /**
     * @Classification 二叉树
     * @Tag 递归、深度优先
     * @Solution 递归遍历整棵二叉树
     *         定义 f(x) 表示 x 节点的子树中是否包含 p 或 q，如果包含，则为 true，否则为 false
     *         那么符合条件的最近公共祖先 x 一定满足以下条件：
     *         f(lson) && f(rson) || ((x = p || x = q) && (f(lson) || f(rson)))
     *         这条公式非常巧妙，需要多品味品味
     * @TimeComplexity O(N) all nodes will be traverse
     * @SpaceComplexity O(N) the stack of recursion
     */
    class Solution {
        private TreeNode ans;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            ans = null;
            dfs(root, p, q);
            return ans;
        }

        private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            // if "root" is null, the nodes does not contain q or q
            if (root == null) return false;
            boolean left = dfs(root.left, p, q);
            boolean right = dfs(root.right, p, q);
            // "hit" represent that it has found the lowest common ancestor
            boolean hit = (left && right) || ((root.val == p.val || root.val == q.val) && (left || right));
            if (hit) {
                ans = root;
            }
            return left || right || root.val == p.val || root.val == q.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}