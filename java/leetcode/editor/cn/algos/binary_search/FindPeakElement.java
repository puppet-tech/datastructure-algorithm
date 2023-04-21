package leetcode.editor.cn.algos.binary_search;

/**
 * 题目：162 寻找峰值
 * @author puppet
 * @since 2022-07-29 11:41:47
 */
public class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    
    /**
     * 见代码注释，注意考虑边界情况
     * @TimeComplexity logN
     * @SpaceComplexity 1
     * @Classification 算法
     * @Tag 二分查找、迭代
     */
    class Solution {
        public int findPeakElement(int[] nums) {
            // 边界条件：检查第一个元素和最后一个元素
            int len = nums.length;
            if (len == 1 || nums[0] > nums[1]) return 0;
            if (nums[len - 1] > nums[len - 2]) return len - 1;
            
            int left = 0, right = len - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                int midValue = nums[mid];
                // 左右两边的数
                int tmpLeft = mid > 0 ? nums[mid - 1] : Integer.MIN_VALUE;
                int tmpRight = mid < len - 1 ? nums[mid + 1] : Integer.MAX_VALUE;
                // 如果刚好大于左右两边的数，说明为其中一个顶峰
                if (midValue > tmpLeft && midValue > tmpRight) return mid;
                // 否则说明处于半山腰，根据情况调整左右边界
                if (midValue > tmpLeft) left = mid + 1;
                if (midValue > tmpRight) right = mid - 1;
                // 如果刚好处于最低锋，则随意
                if (midValue < tmpLeft && midValue < tmpRight) right = mid - 1;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}