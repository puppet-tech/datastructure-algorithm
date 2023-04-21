package leetcode.editor.cn.algos.binary_search;

/**
 * 题目：153 寻找旋转排序数组中的最小值
 * @author puppet
 * @since 2022-07-29 00:14:28
 */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * 核心：旋转排序数据将数据分成两个部分，左边部分的最小值永远大于右边部分的最大值
     * @TimeComplexity logN
     * @SpaceComplexity 1
     * @Classification 算法
     * @Tag 二分查找、迭代
     */
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;
            // 边界条件，当nums元素只有一个，或者旋转后的数据刚好是正序递增（即 1,2,3,4,5）
            if (nums[right] >= nums[left]) return nums[left];
            // 取左边部分最小值，用来做备用参考
            int reference = nums[left];
            while (left <= right) {
                // 取中点 mid
                int mid = left + ((right - left) >> 1);
                // mid 刚好为最小值
                if (nums[mid] < reference && nums[mid] < nums[mid - 1]) return nums[mid];
                // 如果 mid 取在了右边部分
                if (nums[mid] < reference && nums[mid] > nums[mid - 1]) right = mid - 1;
                // 如果 mid 取在了左边部分
                if (nums[mid] >= reference) left = mid + 1;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}