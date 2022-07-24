package top.puppetdev.da.leetcode.editor.cn;

/**
 * 题目：14 最长公共前缀
 * @author puppet
 * @since 2022-07-24 14:28:37
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 先假设第一个字符串为最长的公共前缀 result，然后跟剩下的字符串进行两两对比，不断更新 result，
     * 如果 result 为 ""，则直接返回。因为当 result 为 ”“ 时，肯定是没有公共前缀的
     * @TimeComplexity N
     * @SpaceComplexity 1
     * @Classification 字符串
     * @Tag 剪枝、字符串
     */
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            // 根据题意，strs 中必然有元素
            String result = strs[0];
            int length = strs.length;
            for (int i = 1; i < length; i++) {
                // 剪枝技巧
                if ("".equals(result)) return "";
                result = getCommonPrefix(result, strs[i]);
            }
            return result;
        }

        private String getCommonPrefix(String result, String str) {
            int index = 0;
            while (index < result.length() && index < str.length() && result.charAt(index) == str.charAt(index))
                index++;
            return result.substring(0, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}