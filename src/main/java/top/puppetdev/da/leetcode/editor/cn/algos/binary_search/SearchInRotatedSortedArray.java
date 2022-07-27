package top.puppetdev.da.leetcode.editor.cn.algos.binary_search;

/**
 * 题目：33 搜索旋转排序数组
 * @author puppet
 * @since 2022-07-25 16:15:11
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 核心点：排序数据经过旋转后，左边部分的最小值永远会大于右边部分的最大值
     * @TimeComplexity logN
     * @SpaceComplexity 1
     * @Classification 算法
     * @Tag 二分查找、数组、迭代
     */
    class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            int left = 0, right = len - 1;
            // 参考值，左边部分的最小值
            int reference = nums[0];
            while (left <= right) {
                // 取中点
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) return mid;
                // 如果 target 在左边部分
                if (target >= reference) {
                    if ((nums[mid] >= reference && nums[mid] > target) || nums[mid] < reference) {
                        right = mid - 1;
                        continue;
                    }
                    if (nums[mid] >= reference && nums[mid] < target) {
                        left = mid + 1;
                    }
                } else {
                    // 如果 target 在右边部分
                    if ((nums[mid] < reference && nums[mid] < target) || nums[mid] >= reference) {
                        left = mid + 1;
                        continue;
                    }
                    if (nums[mid] < reference && nums[mid] > target) {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}