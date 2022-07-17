package top.puppetdev.da.leetcode.editor.cn;

import top.puppetdev.da.leetcode.editor.cn.common.TreeNode;

/**
 * 题目：101 对称二叉树
 * @author puppet
 * @since 2022-07-15 17:08:59
 */
public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
     * @Classification
     * @Tag
     * @Solution
     * @TimeComplexity
     * @SpaceComplexity
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}