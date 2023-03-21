package top.puppetdev.da.leetcode.editor.cn;

import top.puppetdev.da.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：113 路径总和 II
 * @author puppet
 * @since 2023-03-16 00:04:47
 */
public class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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
    class Solution {
        List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}