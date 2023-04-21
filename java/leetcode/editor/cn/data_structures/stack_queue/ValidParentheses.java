package leetcode.editor.cn.data_structures.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * 题目：20 有效的括号
 * @author puppet
 * @since 2022-07-19 15:53:36
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        solution.isValid("([)]");
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * @Classification stack and queue
     * @Tag
     * @Solution take advantage of stack properties to check if it is valid
     *         1. ready a stack
     *         2. if encounter (、{、[, push it into the stack
     *         3. if encounter ) } ], pop a element from stack and check whether they are matched
     *         4. finally, all chars of the string have been traversed and the stack is empty, return true
     *         otherwise, e.g. two elements does not match or stack is not empty, return false
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');

            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) stack.push(c);
                else {
                    if (stack.isEmpty()) return false;
                    if (map.get(stack.pop()) != c) return false;
                }
            }
            // if the stack is not empty, return false
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}