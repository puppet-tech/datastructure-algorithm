package leetcode.editor.cn.data_structures.binary_tree;

import leetcode.editor.cn.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：103 二叉树的锯齿形层序遍历
 * @author puppet
 * @since 2022-07-11 22:38:04
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
     *         其实跟“树的层次遍历”思路基本相同，只是需要关注节点值加入数组时的顺序，
     *         需要定义一个布尔值，控制加入的顺序：先从左到右加入，再从右到左加入，交替执行，下面则是层次遍历的核心点：
     *         1. 定义一个队列，用来存放等待遍历的节点
     *         2. 在遍历每一层开始前，需要先将该层的节点数量统计出来，然后整层进行遍历
     *         3. 考虑边界条件：root 为 null 的情况，否则会报空指针异常
     * @TimeComplexity O(N) 每个节点都要遍历一次
     * @SpaceComplexity O(N) 需要一个队列来存储节点
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            boolean flag = true;
            while (!queue.isEmpty()) {
                // 此处不能定义为 ArrayList，而是要定义为 LinkedList，因为要在数组前面插入值
                LinkedList<Integer> level = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    if (flag) level.add(node.val);
                    else level.addFirst(node.val);
                }
                flag = !flag;
                result.add(level);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}