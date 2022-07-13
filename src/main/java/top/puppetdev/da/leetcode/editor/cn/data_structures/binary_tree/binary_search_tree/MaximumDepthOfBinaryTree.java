package top.puppetdev.da.leetcode.editor.cn.data_structures.binary_tree.binary_search_tree;

import top.puppetdev.da.leetcode.editor.cn.common.TreeNode;

/**
 * 题目：104 二叉树的最大深度
 * @author puppet
 * @since 2022-07-13 14:36:28
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    /**
     * @Classification 二叉树
     * @Tag 深度优先遍历、递归
     * @Solution 想求当前节点深度，就要先求左右子树中最大深度 + 1
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    class Solution {
        
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        
    }
//leetcode submit region end(Prohibit modification and deletion)

}