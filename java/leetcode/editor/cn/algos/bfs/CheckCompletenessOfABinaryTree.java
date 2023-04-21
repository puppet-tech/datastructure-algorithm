package leetcode.editor.cn.algos.bfs;

import leetcode.editor.cn.common.TreeNode;

/**
 * 题目：958 二叉树的完全性检验
 * @author puppet
 * @since 2022-08-03 23:44:59
 */
public class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new CheckCompletenessOfABinaryTree().new Solution();
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
     * 核心：节点数量与节点的最大编号相等则为 true，否则为 false
     * 编号规则：假如当前节点变为为 n，则左子树编号则为 n*2，右子树编号为 n*2+1
     * @TimeComplexity N
     * @SpaceComplexity N
     * @Classification 算法
     * @Tag 广度优先遍历、递归
     */
    class Solution {
        private int nodeCount = 0;
        private int maxNumber = 0;

        public boolean isCompleteTree(TreeNode root) {
            bfs(root, 1);
            return maxNumber == nodeCount;
        }

        private void bfs(TreeNode root, int number) {
            if (root == null) return;

            // 开始遍历节点，节点计数加 1
            nodeCount++;
            maxNumber = Math.max(number, maxNumber);

            bfs(root.left, number * 2);
            bfs(root.right, number * 2 + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}