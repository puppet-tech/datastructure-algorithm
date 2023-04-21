package leetcode.editor.cn.data_structures.binary_tree.binary_search_tree;

import leetcode.editor.cn.common.TreeNode;

/**
 * 题目：98 验证二叉搜索树
 * @author puppet
 * @since 2022-07-13 11:09:10
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
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
     * @Tag 二叉搜索树、深度优先遍历（中序遍历）、递归
     * @Solution 中序遍历：二叉搜索树的中序遍历是一个递增序列，反之，如果不是一个递增序列，则说明不是二叉搜索树
     *         因此，我们遍历每个节点的时候，只需要跟前一个节点的值进行比较，如果大于，则是递增，否则，非递增
     * @TimeComplexity O(n) 需要递归遍历每一个节点
     * @SpaceComplexity O(N) 递归栈
     */
    class Solution {
        private int prev = Integer.MIN_VALUE;
        private boolean result = true;
        private boolean first = true;
        
        public boolean isValidBST(TreeNode root) {
            inorder(root);
            return result;
        }
        
        private void inorder(TreeNode root) {
            if (root == null || !result) return;
            
            inorder(root.left);
            // 为了解决极端情况：第一个值为 Integer.MIN_VALUE 的情况，需要设置一个 first 标志位，对其进行特殊处理
            if (root.val > prev || (root.val == Integer.MIN_VALUE && first)) prev = root.val;
            else result = false;
            first = false;
            inorder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}