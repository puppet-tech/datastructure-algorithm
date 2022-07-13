package top.puppetdev.da.leetcode.editor.cn;

import top.puppetdev.da.leetcode.editor.cn.common.TreeNode;

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
     * @Solution 思路：根据题意，即求左右子树最大深度和 + 2
     * @TimeComplexity
     * @SpaceComplexity
     */
    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            // 左右子树的最大深度，还要加 2，才是直径长度
            return getMaxDepth(root.left) + getMaxDepth(root.right) + 2;
        }

        private int getMaxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}