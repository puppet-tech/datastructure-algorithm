package leetcode.editor.cn.data_structures.binary_tree;

import leetcode.editor.cn.common.TreeNode;

/**
 * 题目：112 路径总和
 * @author puppet
 * @since 2022-07-18 00:20:14
 */
public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
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
     * @Tag 递归、深度优先
     * @Solution
     * @TimeComplexity O(N) all nodes needed to be checked
     * @SpaceComplexity O(H) the height of the tree
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            if (root.left == null && root.right == null) return targetSum == root.val;
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}