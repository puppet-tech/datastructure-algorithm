//////给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
//////
////// 
//////
////// 示例 1: 
//////
////// 
//////输入: root = [3,1,4,null,2], k = 1
////// 3
////// / \
////// 1 4
////// \
////// 2
//////输出: 4 
//////
////// 示例 2: 
//////
////// 
//////输入: root = [5,3,6,2,4,null,null,1], k = 3
////// 5
////// / \
////// 3 6
////// / \
////// 2 4
////// /
////// 1
//////输出: 4 
//////
////// 
//////
////// 限制： 
//////
////// 
////// 1 ≤ k ≤ 二叉搜索树元素个数 
////// 
////// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 280 👎 0
////
//

package dev.puppet.leetcode.editor.cn;

import dev.puppet.common_data_structures.TreeNode;

public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /** 全局变量存储结果 */
        private int result, k;

        /**
         * @Tag 二叉搜索树、中序遍历、递归
         * @Solution 核心：二叉搜索树的中序遍历是一个递增序列，则其中序遍历的“倒序”是一个递减序列
         *         求第几大节点，说明只需要求其中序遍历的“倒序”，即可轻松求出第 K 大节点的值
         *         1. 采用递归方式进行中序倒序遍历
         *         2. 每遍历一个节点，对 k 递减，当 k == 0 时，说明节点已经找到
         *         3. 如果节点为 null，则递归终止
         *         4. 如果 k < 0 说明节点已经找到，直接返回
         * @TimeComplexity O(N) 当退化为链表时，所有节点都在右子树，则为 O(N)
         * @SpaceComplexity O(N) 同时间复杂度
         */
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs(root);
            return this.result;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.right);
            this.k--;
            if (this.k < 0) return;
            if (this.k == 0) this.result = root.val;
            dfs(root.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}