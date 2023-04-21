package leetcode.editor.cn;

/**
 * 题目：704 二分查找
 *
 * @author puppet
 * @since 2023-04-18 23:34:49
 */
public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int start = 0, end = nums.length - 1;
            while (start <= end) {
//                int mid = (start + end) >> 1;
                int mid = start + ((end - start) >> 1);
                if (nums[mid] == target) return mid;
                if (nums[mid] < target) start = mid + 1;
                if (nums[mid] > target) end = mid - 1;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}