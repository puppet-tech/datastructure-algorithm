package leetcode.editor.cn.data_structures.binary_tree;

import leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：199 二叉树的右视图
 * @author puppet
 * @since 2022-07-12 09:11:01
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
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
     * @Tag 深度优先遍历、递归
     * @Solution 我们按照 「根结点 -> 右子树 -> 左子树」 的顺序访问，就可以保证每层都是最先访问最右边的节点的。
     *         核心点：如果结果集中没有当前深度的任意节点，则第一个即为最右节点，可以用深度与结果集的长度做比较来判断是否有当前深度节点
     * @TimeComplexity O(N)，每个节点都访问了 1 次。
     * @SpaceComplexity O(N) 因为这不是一棵平衡二叉树，二叉树的深度最少是 logN, 最坏的情况下会退化成一条链表，深度就是 N，因此递归时使用的栈空间是 O(N) 的
     */
    class Solution {
        
        ArrayList<Integer> integers = new ArrayList<>();
        
        public List<Integer> rightSideView(TreeNode root) {
            dfs(root, 0);
            return integers;
        }
        
        private void dfs(TreeNode root, int depth) {
            // 递归终止条件
            if (root == null) return;
            // 如果结果集中没有当前深度的任意节点，则第一个即为最右节点
            if (depth == integers.size()) {
                integers.add(root.val);
            }
            // 深度递增
            depth++;
            dfs(root.right, depth);
            dfs(root.left, depth);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}