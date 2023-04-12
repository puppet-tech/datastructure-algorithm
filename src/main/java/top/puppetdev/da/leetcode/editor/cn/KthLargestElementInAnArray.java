package top.puppetdev.da.leetcode.editor.cn;

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
        int ans;

        public int findKthLargest(int[] nums, int k) {
            if (nums.length == 1) return nums[0];
            this.process(nums, 0, nums.length - 1, nums.length - k);
            return ans;
        }

        private void process(int[] nums, int start, int end, int k) {
            if (start >= end) return;
            int pivot = nums[start], left = start, right = end;
            while (left < right) {
                while (left < right) {
                    if (nums[right] < pivot) {
                        nums[left] = nums[right];
                        break;
                    }
                    right--;
                }
                while (left < right) {
                    if (nums[left] > pivot) {
                        nums[right] = nums[left];
                        break;
                    }
                    left++;
                }
            }
            if (left == k) {
                ans = pivot;
                return;
            }
            nums[left] = pivot;
            if (left > k) process(nums, start, left - 1, k);
            if (left < k) process(nums, left + 1, end, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}