package top.puppetdev.da.leetcode.editor.cn.data_structures.binary_tree;

import top.puppetdev.da.leetcode.editor.cn.common.TreeNode;

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
     * @Solution 核心思路：如果要判断是否为平衡二叉树，则需要知道当前节点的左右子树高度差是否小于等于 1，
     *         如果当前节点的左右子树高度差小于等于 1，再进一步判断左右子树的情况
     *         只要其中有不满足条件的，则递归终止
     * @TimeComplexity O(N ^ 2)
     * @SpaceComplexity O(N)
     */
    class Solution {
        private boolean ret = true;

        public boolean isBalanced(TreeNode root) {
            solve(root);
            return ret;
        }

        private void solve(TreeNode root) {
            if (root == null || !ret) return;
            if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
                solve(root.left);
                solve(root.right);
            } else {
                ret = false;
            }
        }

        private int getHeight(TreeNode root) {
            if (root == null) return 0;
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}