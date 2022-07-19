package top.puppetdev.da.leetcode.editor.cn.data_structures.binary_tree;

import top.puppetdev.da.leetcode.editor.cn.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：105 从前序与中序遍历序列构造二叉树
 * @author puppet
 * @since 2022-07-19 09:52:59
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
     * @Tag 递归、深度优先
     * @Solution 根据前序遍历和中序遍历的规律，递归构建每一个节点
     *         Tips: thanks to finding and accessing root node of inorder frequently,
     *         we suggest to use a map to improve the efficiency of accessing.
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    class Solution {
        private Map<Integer, Integer> indexMap;
        
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int length = inorder.length;
            // initialize hashmap with the specified capacity size
            indexMap = new HashMap<>((int) (length / 0.75 + 1.0));
            // build a hashmap to reduce the time complexity of retrieval
            for (int i = 0; i < length; i++) {
                indexMap.put(inorder[i], i);
            }
            return buildTree(preorder, inorder, 0, length - 1, 0, length - 1);
        }
        
        private TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
            if (preorderLeft > preorderRight) return null;
            
            // the first node of preorder is the root node of the tree
            int preorderRoot = preorderLeft;
            // get the index of root node of inorder
            int inorderRoot = indexMap.get(preorder[preorderRoot]);
            // create node
            TreeNode root = new TreeNode(inorder[inorderRoot]);
            
            int subtreeLeftSize = inorderRoot - inorderLeft;
            root.left = buildTree(preorder, inorder, preorderLeft + 1, preorderLeft + subtreeLeftSize, inorderLeft, inorderRoot - 1);
            root.right = buildTree(preorder, inorder, preorderLeft + subtreeLeftSize + 1, preorderRight, inorderRoot + 1, inorderRight);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}