package leetcode.editor.cn.algos.dfs;

import leetcode.editor.cn.common.TreeNode;

/**
 * 题目：129 求根节点到叶节点数字之和
 * @author puppet
 * @since 2022-08-02 22:22:34
 */
public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        Solution solution = new SumRootToLeafNumbers().new Solution();
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
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode root, int num) {
            if (root == null) return 0;
            num = num * 10 + root.val;
            if (root.left == null && root.right == null) return num;
            else return dfs(root.left, num) + dfs(root.right, num);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}