package top.puppetdev.da.leetcode.editor.cn.algos.sortion;

import java.util.Arrays;

/**
 * 题目：179 最大数
 * @author puppet
 * @since 2022-07-30 19:01:09
 */
public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            if (nums == null) return null;
            int len = nums.length;
            Integer[] integers = new Integer[len];
            for (int i = 0; i < len; i++) {
                integers[i] = nums[i];
            }

            // 如果 a + b > b + a，则 a 排在 b 前面
            Arrays.sort(integers, (x, y) -> {
                int i = 10, j = 10;
                while (i <= y) i *= 10;
                while (j <= x) j *= 10;
                return (int) (y * j + x - (x * i + y));
            });

            if (integers[0] == 0) return "0";

            StringBuilder ans = new StringBuilder();
            for (int num : integers) {
                ans.append(num);
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}