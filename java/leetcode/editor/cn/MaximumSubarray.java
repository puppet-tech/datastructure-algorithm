package top.puppetdev.da.leetcode.editor.cn;

import javax.management.MBeanAttributeInfo;

/**
 * 题目：53 最大子数组和
 * @author puppet
 * @since 2023-04-21 16:50:15
 */
public class MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * define ans to store answer, define num to store temp sum
         * traverse nums，if nums[i] >= 0, then sum += nums[i]
         * otherwise, sum = nums[i]
         * everytime, compare sum and the current ans to get the max value
         * finally, return ans
         * @param nums
         * @return
         */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        int sum = 0, ans = nums[0];
        for (int i = 0; i < length; i++) {
            if (nums[i] >= 0) sum += nums[i];
            else sum = nums[i];
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}