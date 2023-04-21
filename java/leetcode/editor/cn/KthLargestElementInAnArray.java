package leetcode.editor.cn;

/**
 * 题目：215 数组中的第K个最大元素
 *
 * @author puppet
 * @since 2023-04-13 02:23:39
 */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = new int[]{2, 1};
        solution.findKthLargest(nums, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findKthLargest(int[] nums, int k) {
            if (nums.length == 1) return nums[0];
            return this.process(nums, 0, nums.length - 1, nums.length - k + 1);
        }

        private int process(int[] nums, int start, int end, int k) {
            if (start >= end) return nums[start];
            int pivot = nums[start], left = start, right = end;
            while (left < right) {
                while (left < right && nums[right] >= pivot) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] <= pivot) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = pivot;
            if (left == k - 1) return nums[left];
            else if (left > k - 1) return process(nums, start, left - 1, k);
            else return process(nums, left + 1, end, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}