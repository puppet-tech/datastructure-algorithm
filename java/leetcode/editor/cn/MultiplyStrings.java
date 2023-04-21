package leetcode.editor.cn;

/**
 * 题目：43 字符串相乘
 * @author puppet
 * @since 2022-07-23 23:37:35
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * @TimeComplexity
     * @SpaceComplexity
     * @Classification
     * @Tag
     */
    class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) return "0";
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}