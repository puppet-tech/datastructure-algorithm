package top.puppetdev.da.leetcode.editor.cn;

/**
 * 题目：912 排序数组
 *
 * @author puppet
 * @since 2023-04-09 23:05:39
 */
public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        int[] nums = new int[]{3, 2, 2, 2, 2, 2, 2, 2};
        solution.quicksort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            this.quicksort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quicksort(int[] nums, int start, int end) {
            if (start >= end) return;
            // 开始进行分区
            // 随机挑选一个 pivot
            int left = start, right = end;
            int pivot = nums[start];
            while (left < right) {
                while (left < right && nums[right] >= pivot) right--;
                    nums[left] = nums[right];
                while (left < right &&nums[left] <= pivot) left++;
                    nums[right] = nums[left];
            }
            nums[left] = pivot;
            // 用递归进一步分区
            quicksort(nums, start, left - 1);
            quicksort(nums, left + 1, end);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}