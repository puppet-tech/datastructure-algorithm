package top.puppetdev.da.leetcode.editor.cn.data_structures.binary_tree;

import top.puppetdev.da.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：94 二叉树的中序遍历
 * @author puppet
 * @since 2022-07-11 20:14:51
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
     * @Tag 中序遍历、递归
     * @Solution 常规中序遍历
     * @Tip
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    class Solution {
        private ArrayList<Integer> integers = new ArrayList<>();
        
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return integers;
            
            inorderTraversal(root.left);
            integers.add(root.val);
            inorderTraversal(root.right);
            return integers;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}