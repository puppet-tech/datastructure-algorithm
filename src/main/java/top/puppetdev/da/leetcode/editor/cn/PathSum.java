package top.puppetdev.da.leetcode.editor.cn;

import top.puppetdev.da.leetcode.editor.cn.common.TreeNode;

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
     * @Tag
     * @Solution
     * @TimeComplexity
     * @SpaceComplexity
     */
    class Solution {
        private boolean ans;
        
        public boolean hasPathSum(TreeNode root, int targetSum) {
            ans = false;
            dfs(root, targetSum);
            return ans;
        }
        
        private void dfs(TreeNode root, int targetSum) {
            if (targetSum == 0 && root == null) ans = true;
            int sum = root.val - targetSum;
            hasPathSum(root.left, sum);
            hasPathSum(root.right, sum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}