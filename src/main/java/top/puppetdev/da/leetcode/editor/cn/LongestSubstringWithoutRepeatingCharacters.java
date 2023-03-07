package top.puppetdev.da.leetcode.editor.cn;

import java.util.HashSet;

/**
 * 题目：3 无重复字符的最长子串
 * @author puppet
 * @since 2023-03-07 22:25:23
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring(s);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> set = new HashSet<>();
            int length = s.length();
            int ans = 0, rp = 0;
            for (int i = 0; i < length; i++) {
                if (i != 0) set.remove(s.charAt(i - 1));
                while (rp < length && !set.contains(s.charAt(rp))) {
                    set.add(s.charAt(rp));
                    rp++;
                }
                ans = Math.max(rp - i, ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}