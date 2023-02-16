package top.puppetdev.da.leetcode.editor.cn;

/**
 * 题目：31 下一个排列
 * @author puppet
 * @since 2023-01-11 01:29:42
 */
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            if (len <= 1) return;
            int i = len - 2, j = len - 1, k = len - 1;
            while (i >= 0 && nums[j] <= nums[i]) {
                j--;
                i--;
            }
            if (i >= 0) {
                while (nums[k] <= nums[i]) {
                    k--;
                }
                // 交换 i 和 k 的位置
                swap(nums, i, k);
            }
            // 将 [j, end) 后的都进行翻转
            reverse(nums, j);
        }

        private void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        private void swap(int[] nums, int i, int k) {
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}