package dev.puppet.common_data_structures;

/**
 * @author puppet
 * @since 2022/4/13 22:24
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }
}
