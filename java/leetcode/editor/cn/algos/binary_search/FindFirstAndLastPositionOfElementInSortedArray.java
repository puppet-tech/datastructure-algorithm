package leetcode.editor.cn.algos.binary_search;

/**
 * 题目：34 在排序数组中查找元素的第一个和最后一个位置
 * @author puppet
 * @since 2022-07-28 14:59:04
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 两次二分查找，第一次先找到开始位置，第二次再找结束位置
     * @TimeComplexity logN
     * @SpaceComplexity 1
     * @Classification 算法
     * @Tag 二分查找、迭代
     */
    class Solution {
        private int[] ans;

        public int[] searchRange(int[] nums, int target) {
            int[] ans = new int[]{-1, -1};

            // 第二次二分查找，找开始位置
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);

                // 如果刚好等于 target，同时是数组的第一个元素或者前一个元素不相等时，说明是开始位置
                if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) {
                    ans[0] = mid;
                    break;
                }

                if (nums[mid] >= target) right = mid - 1;
                if (nums[mid] < target) left = mid + 1;
            }

            // 第二次二分查找，找结束位置
            left = 0;
            right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);

                // 如果刚好等于 target，同时是数组的最后一个元素或者后一个元素不相等时，说明是结束位置
                if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)) {
                    ans[1] = mid;
                    break;
                }

                if (nums[mid] > target) right = mid - 1;
                if (nums[mid] <= target) left = mid + 1;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}