package leetcode.editor.cn.data_structures.binary_tree;

import leetcode.editor.cn.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：102 二叉树的层序遍历
 * @author puppet
 * @since 2022-07-11 20:19:08
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
     * @Tag 广度优先遍历、队列
     * @Solution 迭代解法
     *         核心点：
     *         1. 定义一个队列，用来存放等待遍历的节点
     *         2. 在遍历每一层开始前，需要先将该层的节点数量统计出来，然后整层进行遍历
     *         3. 考虑边界条件：root 为 null 的情况，否则会报空指针异常
     * @TimeComplexity O(N) 每个节点都要遍历一次
     * @SpaceComplexity O(N) 需要一个队列来存储节点
     */
    class Solution {
        
        public List<List<Integer>> levelOrder(TreeNode root) {
            // 定义一个全局二维数据，用来存放结果
            List<List<Integer>> ret = new ArrayList<>();
            // 边界条件：如果没有一个节点，则直接返回
            if (root == null) return ret;
            
            // 定义一个顺序队列（即基于数组实现的队列）
            Queue<TreeNode> queue = new ArrayDeque<>();
            // 先将根节点放进去
            queue.add(root);
            
            while (!queue.isEmpty()) {
                ArrayList<Integer> level = new ArrayList<>();
                // 统计该层的节点数量
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    // 取出一个节点
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    // 将左右子节点加入队列中
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                ret.add(level);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}