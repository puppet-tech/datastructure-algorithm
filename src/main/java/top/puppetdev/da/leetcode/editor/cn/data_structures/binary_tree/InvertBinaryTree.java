package top.puppetdev.da.leetcode.editor.cn.data_structures.binary_tree;

import top.puppetdev.da.leetcode.editor.cn.common.TreeNode;

/**
 * 题目：226 翻转二叉树
 * @author puppet
 * @since 2022-07-17 09:39:21
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
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
     * @Tag 递归
     * @Solution 对整棵树进行递归遍历
     *         先从叶子节点进行翻转，递归回到 root 根节点时，其他节点均已翻转完毕，再进行最后的翻转即可
     * @TimeComplexity O(N) 每个节点都需要遍历一次
     * @SpaceComplexity O(N) the stack of recursion
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            // recursion termination condition
            if (root == null) return root;
            // recursion
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            // swap the left and right nodes.
            root.left = right;
            root.right = left;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}