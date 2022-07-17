package top.puppetdev.da.leetcode.editor.cn.data_structures.binary_tree;

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
     * @Classification 二叉树
     * @Tag 深度优先遍历、递归、双指针
     * @Solution
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        private boolean check(TreeNode p, TreeNode q) {
            // there are four cases of p and q
            // p == null and q == null, p != null and p != null
            // p == null and q != null, p !=null and q == null
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}