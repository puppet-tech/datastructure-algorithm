package top.puppetdev.da.leetcode.editor.cn.data_structures.string;

/**
 * 题目：8 字符串转换整数 (atoi)
 * @author puppet
 * @since 2022-07-22 21:01:05
 */
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 这道题主要是考察对数据的处理，并没有用到什么算法
     * 1. 需要去掉前导空格
     * 2. 判断第 1 个字符为 + 和 - 的情况。可以设计一个 sign 变量存储，初始值为 1，如果遇到 "-"，则改为 -1
     * 3. 判断是否为数字，采用 ASCII 码进行判断即可：'0' <= c <= '9'
     * 4. 如果不是数字，则停止遍历
     * 注意事项：转换前需要判断是否整数溢出了
     * @TimeComplexity n
     * @SpaceComplexity 1
     * @Classification string
     * @Tag math, string
     */
    class Solution {
        public int myAtoi(String s) {
            int index = 0;
            char space = ' ';
            int sign = 1;
            int length = s.length();
            // skip the leading space
            while (index < length && s.charAt(index) == space) {
                index++;
            }
            // determine whether it is positive or negative
            if (index < length && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
                sign = s.charAt(index) == '-' ? -sign : sign;
                index++;
            }
            int ans = 0;
            // begin to transform string to integer
            while (index < length && '0' <= s.charAt(index) && s.charAt(index) <= '9') {
                int num = s.charAt(index) - '0';
                // judge if overflow
                if (ans > (Integer.MAX_VALUE - num) / 10) return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                ans = ans * 10 + num;
                index++;
            }

            return ans * sign;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}