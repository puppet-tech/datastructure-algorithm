package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：227 基本计算器 II
 *
 * @author puppet
 * @since 2023-04-05 01:19:34
 */
public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            int len = s.length(), num = 0;
            char preSign = '+';
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                if ((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                    if (preSign == '+') stack.push(num);
                    else if (preSign == '-') stack.push(-num);
                    else if (preSign == '*') stack.push(stack.pop() * num);
                    else stack.push(stack.pop() / num);
                    preSign = c;
                    num = 0;
                }
            }

            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}