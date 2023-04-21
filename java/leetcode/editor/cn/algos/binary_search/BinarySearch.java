package leetcode.editor.cn.algos.binary_search;

/**
 * 题目：704 二分查找
 * @author puppet
 * @since 2022-07-25 16:02:47
 */
public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 有两种解法，一种是迭代，一种是递归，这里采用递归解法
     * @TimeComplexity logN 时间复杂度
     * @SpaceComplexity logN 递归栈
     * @Classification 算法
     * @Tag 二分查找、递归
     */
    class Solution {
        public int search(int[] nums, int target) {
            int length = nums.length;
            return process(nums, 0, length - 1, target);
        }

        private int process(int[] nums, int left, int right, int target) {
            if (left >= right) return nums[left] == target ? left : -1;
            // 去中点，避免整数溢出，同时提升性能
            int pivot = left + ((right - left) >> 1);
            if (nums[pivot] == target) return pivot;
            if (nums[pivot] > target) return process(nums, left, pivot - 1, target);
            if (nums[pivot] < target) return process(nums, pivot + 1, right, target);
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}