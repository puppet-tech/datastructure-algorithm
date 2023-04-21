package leetcode.editor.cn.data_structures.binary_tree;

import leetcode.editor.cn.common.TreeNode;

/**
 * 题目：543 二叉树的直径
 * @author puppet
 * @since 2022-07-13 23:27:11
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
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
    /**
     * @Classification 二叉树
     * @Tag 深度优先遍历、递归
     * @Solution 思路：遍历比较每个节点的最大直径，例如经过根节点的最大直径
     *         求每个节点的最大深度，求最大深度时，需要求其左右子树的深度，取最大的 +1，则为以当前节点为根节点的树的深度
     *         而以当前节点为根节点的树，其经过当前节点的最大直径恰好为其左右子树的深度和
     *         所以可以在求每个节点的最大深度过程中，将我们要求的树的最大节点求出来，具体看代码
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    class Solution {
        private int ans;
        
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 0;
            getMaxDepth(root);
            return ans;
        }
        
        private int getMaxDepth(TreeNode root) {
            if (root == null) return 0;
            // get the maximum depth of the left child of root.
            int leftChildrenDepth = getMaxDepth(root.left);
            // get the maximum depth of the right child of root.
            int rightChildrenDepth = getMaxDepth(root.right);
            ans = Math.max(ans, leftChildrenDepth + rightChildrenDepth);
            return Math.max(leftChildrenDepth, rightChildrenDepth) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}