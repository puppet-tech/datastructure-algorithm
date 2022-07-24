package top.puppetdev.da.leetcode.editor.cn;

/**
 * 题目：215 数组中的第K个最大元素
 * @author puppet
 * @since 2022-07-24 14:28:59
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 根据题意，我们假设数组的长度为 n，则要求的是数组排序后的倒数第 k 个位置
     * 思路：
     * <p>
     * 改进快排算法，在进行分治拆分左右部分的时候，判断当前划分到的 q 正好是我们的需要的下标，则可以直接返回 a[q]
     * 如果 q 下标比目标的小，则递归右子区间，否则递归左子区间
     * </p>
     * @TimeComplexity logN
     * @SpaceComplexity N
     * @Classification 算法思想
     * @Tag 快排、数组、分治
     */
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        private int quickSelect(int[] nums, int i, int i1, int i2) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}