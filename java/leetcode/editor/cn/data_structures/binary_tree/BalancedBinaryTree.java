package leetcode.editor.cn.data_structures.binary_tree;

import leetcode.editor.cn.common.TreeNode;

/**
 * 题目：110 平衡二叉树
 * @author puppet
 * @since 2022-07-13 18:35:59
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
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
     * @Solution 核心思路：如果要判断是否为平衡二叉树，则需要知道当前节点的左右子树深度差是否小于等于 1，
     *         本质其实是求深度，递归求解每个节点的左右子树的最大深度，然后对左右子树的最大深度进行比较
     *         如果存在节点的左右子树的深度差大于 1，说明不是二叉平衡树，直接退出迭代
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    class Solution {
        private boolean ret;
        
        public boolean isBalanced(TreeNode root) {
            ret = true;
            getMaxDepth(root);
            return ret;
        }
        
        private int getMaxDepth(TreeNode root) {
            // adding "!ret" can exit the iteration in advance
            if (root == null || !ret) return 0;
            int lDepth = getMaxDepth(root.left);
            int rDepth = getMaxDepth(root.right);
            if (Math.abs(lDepth - rDepth) > 1) ret = false;
            return Math.max(lDepth, rDepth) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}