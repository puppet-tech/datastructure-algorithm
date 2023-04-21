package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：20 有效的括号
 *
 * @author puppet
 * @since 2023-04-05 18:54:38
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
         /*
         定义一个栈
         遍历整个字符串
         如果遇到左括号，就放入栈中，如果遇到有括号，就把栈顶的括号拿出来匹配
         如果匹配不对，则直接返回false，如果匹配得上，则继续遍历
         直到字符串被遍历完，检查栈中是否还有元素，如果有，则返回 false，如果没有，则返回 true
          */
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '{' || c == '(' || c == '[') stack.push(c);
                else {
                    if (stack.isEmpty()) return false;
                    Character pop = stack.pop();
                    if (c == ')' && pop != '(') return false;
                    if (c == '}' && pop != '{') return false;
                    if (c == ']' && pop != '[') return false;
                }
            }
            return stack.isEmpty();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}