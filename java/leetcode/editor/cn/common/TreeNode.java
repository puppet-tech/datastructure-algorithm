package leetcode.editor.cn.common;

/**
 * @author puppet
 * @since 2022/7/11 15:08
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode() {
    }
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
