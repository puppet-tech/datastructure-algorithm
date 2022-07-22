package top.puppetdev.da.leetcode.editor.cn.data_structures.string;

/**
 * 题目：415 字符串相加
 * @author puppet
 * @since 2022-07-22 13:07:42
 */
public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * simulate vertical operation in mathematics
     * these are two tricks: 1. pad length with 0; 2. pay attention to the carry
     * @TimeComplexity N
     * @SpaceComplexity 1
     * @Classification string
     * @Tag string, math, simulation
     */
    class Solution {
        public String addStrings(String num1, String num2) {
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int carry = 0;
            // store answer
            StringBuilder ans = new StringBuilder();
            while (i >= 0 || j >= 0 || carry != 0) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                int num = x + y + carry;
                ans.append(num % 10);
                carry = num / 10;
                i--;
                j--;
            }
            return ans.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}