package leetcode.editor.cn;

/**
 * 题目：8 字符串转换整数 (atoi)
 *
 * @author puppet
 * @since 2023-04-14 16:16:05
 */
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        1. 定义 sign 遍历，记录数字的正负，默认为 1，下面遍历字符串的过程中，如果遇到 -，则将其设为 -1
        2. 用 while 遍历整个字符串，
            先跳过前导空格，
            如果遇到正负号，则修改 sign，然后继续遍历（需要考虑 - 是否有多个）
            如果遇到数字，则一直拼接这个数字，直到没有数字为止，跳出循环，终止遍历
        3. 返回答案，注意整数范围截断问题
         */
        public int myAtoi(String s) {
            int ans = 0, sign = 1, length = s.length(), index = 0;
            char space = ' ';
            while (index < length && s.charAt(index) == space) index++;
            if (index < length && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
                sign = s.charAt(index) == '-' ? -sign : sign;
                index++;
            }
            while (index < length && Character.isDigit(s.charAt(index))) {
                int num = s.charAt(index) - '0';
                if (ans > (Integer.MAX_VALUE - num) / 10) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                ans = ans * 10 + num;
                index++;
            }
            return ans * sign;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}