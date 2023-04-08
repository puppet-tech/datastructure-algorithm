package top.puppetdev.da.leetcode.editor.cn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 题目：394 字符串解码
 *
 * @author puppet
 * @since 2022-07-24 14:28:47
 */
public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        String s = "abc3[cd]xyz";
        solution.decodeString(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /*
        定义一个栈，然后遍历字符串
        如果遇到数字（可能有多位）、字符或者左括号，则直接入栈
        如果遇到右括号，则开始出栈，直到出栈元素为左括号为止，将所有出栈的元素拼接成字符串（注意顺序）
        拼接后，再次获取一次栈顶元素（一定为数字），根据数字构建字符串，最后将构建的字符串再次入栈，继续遍历
        最后将栈输出为字符串，栈底到栈顶，即为答案
         */
        public String decodeString(String s) {
            LinkedList<String> stack = new LinkedList<>();
            int length = s.length();
            int times = 0;
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    times = times * 10 + c - '0';
                    continue;
                }
                if (i > 0 && Character.isDigit(s.charAt(i - 1))) {
                    stack.push(String.valueOf(times));
                    times = 0;
                }

                if (!Character.isDigit(c) && c != ']') stack.push(String.valueOf(c));
                else {
                    LinkedList<String> temp = new LinkedList<>();
                    while (!Objects.equals(stack.peek(), "[")) {
                        temp.add(stack.pop());
                    }
                    Collections.reverse(temp);
                    stack.removeFirst();
                    int num = Integer.parseInt(stack.pop());
                    stack.push(String.join("", temp).repeat(Math.max(0, num)));
                }
            }

            // 输出答案
            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()) ans.append(stack.pollLast());
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}