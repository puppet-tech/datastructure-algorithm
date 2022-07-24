package top.puppetdev.da.leetcode.editor.cn.data_structures.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：151 颠倒字符串中的单词
 * @author puppet
 * @since 2022-07-22 21:52:22
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        solution.reverseWords("  Bob    Loves  Alice   ");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * After word-by-word recognition, put the word into ans,
     * and finally splicing it into a string through the String.join method to return
     * @TimeComplexity N
     * @SpaceComplexity N
     * @Classification string
     * @Tag logic
     */
    class Solution {
        public String reverseWords(String s) {
            // skip the leading spaces
            int length = s.length();
            char space = ' ';
            Deque<String> ans = new ArrayDeque<>();
            StringBuilder word = new StringBuilder();
            int index = 0;

            // skip the leading spaces
            while (s.charAt(index) == space) index++;

            boolean first = true;
            while (index < length) {
                char c = s.charAt(index);
                if (!first && c == space) {
                    index++;
                    continue;
                }
                if (!first && c != space) first = true;
                if (c != space) {
                    word.append(c);
                    index++;
                    continue;
                }
                ;
                if (first && c == space) {
                    ans.offerFirst(word.toString());
                    word.setLength(0);
                    index++;
                    first = false;
                }
            }
            // if the end has no any spaces
            if (word.length() != 0) ans.offerFirst(word.toString());

            return String.join(" ", ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}