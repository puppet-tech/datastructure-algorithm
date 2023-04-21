package leetcode.editor.cn.algos.sortion;

/**
 * 题目：912 排序数组
 * @author puppet
 * @since 2022-07-29 14:21:26
 */
public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 简单排序，可以用快速排序，也可以用归并排序
     * @TimeComplexity logN
     * @SpaceComplexity logN
     * @Classification 算法
     * @Tag 快速排序
     */
    class Solution {
        public int[] sortArray(int[] nums) {
            process(nums, 0, nums.length - 1);
            return nums;
        }

        private void process(int[] nums, int start, int end) {
            // 递归终止条件
            if (start >= end) return;

            int left = start, right = end;
            int pivot = nums[start];
            while (start < end) {
                while (start < end && nums[end] >= pivot) end--;
                nums[start] = nums[end];
                while (start < end && nums[start] <= pivot) start++;
                nums[end] = nums[start];
            }
            nums[start] = pivot;
            process(nums, left, start - 1);
            process(nums, start + 1, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}