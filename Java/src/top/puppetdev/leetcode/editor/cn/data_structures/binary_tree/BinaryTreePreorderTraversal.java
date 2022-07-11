package top.puppetdev.leetcode.editor.cn.data_structures.binary_tree;

import top.puppetdev.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：144 二叉树的前序遍历
 * @author puppet
 * @since 2022-07-11 15:06:38
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
     * @Tag 前序遍历、递归
     * @Solution
     * @Tip
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N) 递归调用栈
     */
    class Solution {

        private ArrayList<Integer> integers = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return integers;

            integers.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return integers;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}